package com.hyungjun.springredis.controller;

import com.hyungjun.springredis.SignUpForm;
import com.hyungjun.springredis.domain.Account;
import com.hyungjun.springredis.domain.AccountRepository;
import com.hyungjun.springredis.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;
    private final AccountService accountService;

    @PostMapping("/account")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpForm signUpForm) {

        Account savedAccount = accountService.processSignUpNewAccount(signUpForm);

        return ResponseEntity.ok().body(savedAccount);
    }

    @GetMapping("/account")
    public ResponseEntity<?> getAccount(@RequestParam Long id) {

        Account account = accountRepository.findById(id).get();
        accountService.findAllKeys();

        return ResponseEntity.ok().body(account);
    }
}
