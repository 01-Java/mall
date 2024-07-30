package com.smallschool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.smallschool.mapper")
public class SmallSchoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(SmallSchoolApplication.class, args);
	}

}
