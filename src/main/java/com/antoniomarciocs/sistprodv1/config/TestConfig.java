package com.antoniomarciocs.sistprodv1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.antoniomarciocs.sistprodv1.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDataBase() throws Exception {
		
		dbService.instantiateTestDatabase();
		return true;
	}
}
