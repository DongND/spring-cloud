package com.nt.training.configserverfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigserverFileBackedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigserverFileBackedApplication.class, args);
	}

}
