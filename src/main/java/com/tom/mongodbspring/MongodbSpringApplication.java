package com.tom.mongodbspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MongodbSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbSpringApplication.class, args);
	}

	@Autowired
	MongoDbConfig mongoDbConfig;

	@EventListener(ApplicationReadyEvent.class)
	public void get(){
		mongoDbConfig.tryAddElement();
	}
}
