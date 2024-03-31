package org.delivery.api.domain.user.converter;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.Converter;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.user.controller.model.UserRegisterRequest;
import org.delivery.api.domain.user.controller.model.UserResponse;
import org.delivery.db.user.UserEntity;

import java.util.Optional;

@RequiredArgsConstructor
@Converter
public class UserConverter {
    public UserEntity toEntity(UserRegisterRequest userRegisterRequest){
        return Optional.ofNullable(userRegisterRequest)
                .map(it -> {
                    return UserEntity.builder()
                            .name(it.getName())
                            .address(it.getAddress())
                            .email(it.getEmail())
                            .password(it.getPassword())
                            .build();
                }).orElseThrow(()->new ApiException(ErrorCode.NULL_POINT,"userRegisterRequestNull"));
    }

    public UserResponse toResponse(UserEntity newEntity) {
        return Optional.ofNullable(newEntity)
                .map(it -> {
                    return UserResponse.builder()
                            .name(newEntity.getName())
                            .address(newEntity.getAddress())
                            .id(newEntity.getId())
                            .registeredAt(newEntity.getRegisteredAt())
                            .unregisteredAt(newEntity.getUnregisteredAt())
                            .lastLoginAt(newEntity.getLastLoginAt())
                            .email(newEntity.getEmail())
                            .status(newEntity.getStatus())
                            .build();
                }).orElseThrow(()->new ApiException(ErrorCode.NULL_POINT,"userRegisterRequestNull"));
    }
}
