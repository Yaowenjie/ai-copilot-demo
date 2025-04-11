package com.example.pspdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.pspdemo")
public class PspDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(PspDemoApplication.class, args);
    }
}
