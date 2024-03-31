package org.delivery.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TokenErrorCode implements ErrorCodeIfs{

    INVALID_TOKEN(400,2000,"유효하지않은 토큰"),
    EXPIRED_TOKEN(400,20001,"만료된 토큰"),
    TOKEN_EXCEPTION(400,2002,"토큰 알수없는 에러"),
    AUTHORIZATION_TOKEN_NOT_FOUND(400,2003,"토큰 없음 에러");

    private final Integer httpStatusCode;

    private final Integer errorCode;

    private final String description;
}
