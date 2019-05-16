package io.kylemckee.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("io.kylemckee.shapes")
public class ShapeApiApp {

	public static void main(String[] args) {
		SpringApplication.run(ShapeApiApp.class, args);
	}
}
