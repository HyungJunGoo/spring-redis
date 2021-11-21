package com.hyungjun.springredis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@RedisHash("account")
public class Account implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private String password;

    private String bio;

}
