package com.bonc.tender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Configuration
public class StartUp extends  WebMvcConfigurerAdapter{

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StartUp.class, args);
	}

}
