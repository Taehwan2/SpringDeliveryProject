package org.delivery.api.domain.token.business;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.Business;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.token.controller.model.TokenResponse;
import org.delivery.api.domain.token.converter.TokenConverter;
import org.delivery.api.domain.token.service.TokenService;
import org.delivery.db.user.UserEntity;

import java.util.Optional;

@Business
@RequiredArgsConstructor
public class TokenBusiness {
        private final TokenService tokenService;
        private final TokenConverter tokenConverter;

        public TokenResponse issueToken(UserEntity userEntity){
            return Optional.ofNullable(userEntity)
                    .map(it->{
                        return it.getId();
                    }).map(userId->{
                        var accesstoken = tokenService.issueAccessToken(userId);
                        var refreshtoken = tokenService.issueRefreshToken(userId);
                        return tokenConverter.toResponse(accesstoken,refreshtoken);
                    })
            .orElseThrow(()->new ApiException(ErrorCode.NULL_POINT));
        }

        public Long validationAccessToken(String accessToken){
            var userId = tokenService.validationToken(accessToken);
            return userId;
        }

}
