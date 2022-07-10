package com.example.Klein;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.Klein.dao")
public class KleinApplication {

	public static void main(String[] args) {
		SpringApplication.run(KleinApplication.class, args);
	}

}
