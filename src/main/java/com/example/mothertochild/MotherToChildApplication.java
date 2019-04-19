package com.example.mothertochild;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MotherToChildApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotherToChildApplication.class, args);
    }

}
