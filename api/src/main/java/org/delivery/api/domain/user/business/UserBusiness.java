package org.delivery.api.domain.user.business;


import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.Business;
import org.delivery.api.common.api.Api;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.token.business.TokenBusiness;
import org.delivery.api.domain.token.controller.model.TokenResponse;
import org.delivery.api.domain.user.controller.model.UserLoginRequest;
import org.delivery.api.domain.user.controller.model.UserRegisterRequest;
import org.delivery.api.domain.user.controller.model.UserResponse;
import org.delivery.api.domain.user.converter.UserConverter;
import org.delivery.api.domain.user.service.UserService;

import java.util.Optional;

@RequiredArgsConstructor
@Business
public class UserBusiness {
    private final UserService userService;
    private final UserConverter userConverter;


    private final TokenBusiness tokenBusiness;
    //사용자 가입 처리 로직
    public UserResponse register(UserRegisterRequest request) {
        /*
        var entity = userConverter.toEntity(request);
        var newEntity = userService.register(entity);
        var response = userConverter.toResponse(newEntity);
        return response;
        */
        return Optional.ofNullable(request)
                .map(userConverter::toEntity)
                .map(userService::register)
                .map(userConverter::toResponse)
                .orElseThrow(()->new ApiException(ErrorCode.NULL_POINT,"requestIsNull"));
    }

    public TokenResponse login(UserLoginRequest request) {
    var userEnity = userService.login(request.getEmail(),request.getPassword());
    var tokenResponse = tokenBusiness.issueToken(userEnity);
    return tokenResponse;
    }

    public UserResponse  me(Long userId) {
        var userEntity = userService.getUserWithThrow(userId);
        var response = userConverter.toResponse(userEntity);
        return response;
    }
}
