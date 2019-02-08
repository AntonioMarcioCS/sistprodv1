package com.antoniomarciocs.sistprodv1;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.antoniomarciocs.sistprodv1.domain.Canteiro;
import com.antoniomarciocs.sistprodv1.domain.Criatorio;
import com.antoniomarciocs.sistprodv1.domain.Setor;
import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;
import com.antoniomarciocs.sistprodv1.repositories.CanteiroRepository;
import com.antoniomarciocs.sistprodv1.repositories.CriatorioRepository;
import com.antoniomarciocs.sistprodv1.repositories.SetorRepository;
import com.antoniomarciocs.sistprodv1.repositories.SistemaProducaoRepository;

@SpringBootApplication
public class Sistprodv1Application implements CommandLineRunner {

	@Autowired
	private SistemaProducaoRepository sistemaProducaoRepository;
	
	@Autowired
	private SetorRepository setorRepository;
	
	@Autowired
	private CanteiroRepository canteiroRepository;
	
	@Autowired
	private CriatorioRepository criatorioRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Sistprodv1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		SistemaProducao sistema1 = new SistemaProducao(null,"Sisteminha",100.0, 80.0);
		SistemaProducao sistema2 = new SistemaProducao(null,"Sisteminha do IF",50.0, 50.0);
	
		Setor setor1 = new Setor(null,"Hortalícias","Sul", sistema1);
		Setor setor2 = new Setor(null,"Galinhas","Norte", sistema2);
		
		Canteiro canteiro1 = new Canteiro(null,"Canteiro do Repolho", 100.0, 20.0, setor1);
		Canteiro canteiro2 = new Canteiro(null,"Canteiro do Alface", 100.0, 20.0, setor1);
				
		Criatorio criatorio1 = new Criatorio(null,"Tanque de Peixes", 100.0, 20.0, 10.0, setor2);
		Criatorio criatorio2 = new Criatorio(null,"Poleiro das galinhas", 100.0, 20.0, 0.0, setor2);
		
		sistema1.getSetores().addAll(Arrays.asList(setor1,setor2));
		
		setor1.getCanteiros().addAll(Arrays.asList(canteiro1,canteiro2));
				
		setor2.getCriatorios().addAll(Arrays.asList(criatorio1,criatorio2));
		
		sistemaProducaoRepository.saveAll(Arrays.asList(sistema1,sistema2));
		setorRepository.saveAll(Arrays.asList(setor1,setor2));
		canteiroRepository.saveAll(Arrays.asList(canteiro1,canteiro2));
		criatorioRepository.saveAll(Arrays.asList(criatorio1,criatorio2));
		
	}
	
	

}

