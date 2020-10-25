package br.com.mjv.noticias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class TaskNoticiassApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskNoticiassApplication.class, args);
	}

}
