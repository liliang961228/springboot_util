package com.wkk.wkkbjsb.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

//@MapperScan(value = {"com.wkk.wkkbjsb.**.dao"})
public class WkkbjApplication {

    public static void main(String[] args) {

        SpringApplication.run(WkkbjApplication.class, args);
    }

}
