package com.rakib.springtransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class SpringTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTransactionApplication.class, args);
    }

}
