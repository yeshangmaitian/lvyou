package com.example.lvyou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.example.lvyou.mapper")
@SpringBootApplication
public class LvyouApplication {
	public static void main(String[] args) {
		SpringApplication.run(LvyouApplication.class, args);
	}
}