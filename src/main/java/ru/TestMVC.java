package ru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestMVC {
    public static void main(String[] args) {
        SpringApplication.run(TestMVC.class, args).getBeanFactory();
    }
}
