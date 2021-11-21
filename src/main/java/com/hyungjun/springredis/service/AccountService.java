package com.hyungjun.springredis.service;

import com.hyungjun.springredis.SignUpForm;
import com.hyungjun.springredis.domain.Account;
import com.hyungjun.springredis.domain.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AccountService {

    @Autowired
    private RedisTemplate redisTemplate;

    private final AccountRepository accountRepository;

    @Transactional
    public Account processSignUpNewAccount(SignUpForm signUpForm) {
        System.out.println("signUpForm = " + signUpForm.getName() + " " + signUpForm.getEmail());
        Account newAccount = Account.builder()
                .name(signUpForm.getName())
                .email(signUpForm.getEmail())
                .password(signUpForm.getPassword())
                .build();
        Account savedAccount = accountRepository.save(newAccount);
        return savedAccount;
    }

    public void findAllKeys() {

        Set keys = redisTemplate.keys("account");
        System.out.println("keys = " + keys);
    }

//    public Account findAccountFromRedis(Long id) {
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//
//    }
}
