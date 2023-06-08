package com.iread.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.iread.account.dao"})
public class IReadApplication {

  public static void main(String[] args) {
    SpringApplication.run(IReadApplication.class, args);
  }
}
