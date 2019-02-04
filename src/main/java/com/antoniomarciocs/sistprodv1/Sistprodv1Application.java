package com.antoniomarciocs.sistprodv1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;
import com.antoniomarciocs.sistprodv1.repositories.SistemaProducaoRepository;

@SpringBootApplication
public class Sistprodv1Application implements CommandLineRunner {

	@Autowired
	private SistemaProducaoRepository sistemaProducaoRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(Sistprodv1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		SistemaProducao sist1 = new SistemaProducao(null,"Sisteminha",100.3, 80.4);
		SistemaProducao sist2 = new SistemaProducao(null,"Sisteminha do IF",100.7, 100.4);
	
		sistemaProducaoRepository.saveAll(Arrays.asList(sist1,sist2));
	}
	
	

}

