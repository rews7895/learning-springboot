package com.generation.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing	// created_at, updated_at 자동 업데이트
@SpringBootApplication
public class GenerationApplication {

	// main 메소드부터 스프링 부트가 시작
	public static void main(String[] args) {
		// 애플리케이션을 실행
		SpringApplication.run(GenerationApplication.class, args);
	}

}
