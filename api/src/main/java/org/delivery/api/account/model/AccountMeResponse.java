package org.delivery.api.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
//snack case로 변경해서 출력
//@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class) -> objectMapper 설정을 통해서 
public class AccountMeResponse {
    private String email;

    private String name;

    private LocalDateTime registeredAt;

}
