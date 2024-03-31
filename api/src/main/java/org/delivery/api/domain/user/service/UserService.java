package org.delivery.api.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.error.UserErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.db.user.UserEntity;
import org.delivery.db.user.UserRespository;
import org.delivery.db.user.enums.UserStataus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//user 도메인 로직을 처리하는 서비스
public class UserService {
    private final UserRespository userRespository;

    public UserEntity register(UserEntity userEntity){
        return Optional.ofNullable(userEntity)
                .map(it ->{
                    userEntity.setStatus(UserStataus.REGISTERED);
                    userEntity.setRegisteredAt(LocalDateTime.now());
                    return userRespository.save(userEntity);
                }).orElseThrow(()->new ApiException(ErrorCode.NULL_POINT,"UserEntityIsNull"));
    }


    public UserEntity login(
        String email, String password
    ){
        var entity = getUserWithThrow(email,password);
        return entity;
    }

    public UserEntity getUserWithThrow(String email, String password){
        return userRespository.findFirstByEmailAndPasswordAndStatusOrderByIdDesc(email,password,UserStataus.REGISTERED).orElseThrow(()->new ApiException(ErrorCode.NULL_POINT));
    }

    public UserEntity getUserWithThrow(Long userId){
        return userRespository.findFirstByIdAndStatusOrderByIdDesc(userId,UserStataus.REGISTERED).orElseThrow(()->new ApiException(UserErrorCode.USER_NOT_FOUND));
    }
}
