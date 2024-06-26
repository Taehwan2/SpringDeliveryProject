package org.delivery.api.account;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.api.Api;
import org.delivery.db.account.AccountRepository;
import org.delivery.api.account.model.AccountMeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;

    @GetMapping("/me")
    public Api<AccountMeResponse> save(){

        var response = AccountMeResponse.builder()
                .name("홍길동")
                .email("A@gmail.com")
                .registeredAt(LocalDateTime.now())
                .build();

        return Api.ok(response);
    }
}
