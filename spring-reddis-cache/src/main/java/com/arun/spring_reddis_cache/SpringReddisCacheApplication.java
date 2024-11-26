package com.arun.spring_reddis_cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringReddisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReddisCacheApplication.class, args);
	}

}
