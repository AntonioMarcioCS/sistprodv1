package com.antoniomarciocs.sistprodv1.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.antoniomarciocs.sistprodv1.domain.Animal;
import com.antoniomarciocs.sistprodv1.domain.Canteiro;
import com.antoniomarciocs.sistprodv1.domain.Colheita;
import com.antoniomarciocs.sistprodv1.domain.Criatorio;
import com.antoniomarciocs.sistprodv1.domain.Cultura;
import com.antoniomarciocs.sistprodv1.domain.Defensivo;
import com.antoniomarciocs.sistprodv1.domain.Fertilizante;
import com.antoniomarciocs.sistprodv1.domain.Grupo;
import com.antoniomarciocs.sistprodv1.domain.Irrigacao;
import com.antoniomarciocs.sistprodv1.domain.Plantio;
import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;
import com.antoniomarciocs.sistprodv1.domain.Usuario;

import com.antoniomarciocs.sistprodv1.domain.enums.Perfil;
import com.antoniomarciocs.sistprodv1.domain.enums.StatusRetirada;
import com.antoniomarciocs.sistprodv1.domain.enums.TipoAnimal;
import com.antoniomarciocs.sistprodv1.domain.enums.TipoCriatorio;
import com.antoniomarciocs.sistprodv1.domain.enums.TipoUsuario;

import com.antoniomarciocs.sistprodv1.repositories.AnimalRepository;
import com.antoniomarciocs.sistprodv1.repositories.CanteiroRepository;
import com.antoniomarciocs.sistprodv1.repositories.ColheitaRepository;
import com.antoniomarciocs.sistprodv1.repositories.CriatorioRepository;
import com.antoniomarciocs.sistprodv1.repositories.CulturaRepository;
import com.antoniomarciocs.sistprodv1.repositories.DefensivoRepository;
import com.antoniomarciocs.sistprodv1.repositories.FertilizanteRepository;
import com.antoniomarciocs.sistprodv1.repositories.GrupoRepository;
import com.antoniomarciocs.sistprodv1.repositories.IrrigacaoRepository;
import com.antoniomarciocs.sistprodv1.repositories.PlantioRepository;
import com.antoniomarciocs.sistprodv1.repositories.SistemaProducaoRepository;
import com.antoniomarciocs.sistprodv1.repositories.UsuarioRepository;

@Service
public class DBService {
	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private SistemaProducaoRepository sistemaProducaoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private CanteiroRepository canteiroRepository;
	@Autowired
	private CriatorioRepository criatorioRepository;
	@Autowired
	private AnimalRepository animalRepository;
	@Autowired
	private GrupoRepository grupoRepository;
	@Autowired
	private CulturaRepository culturaRepository;
	@Autowired
	private PlantioRepository plantioRepository;
	@Autowired
	private DefensivoRepository defensivoRepository;
	@Autowired
	private IrrigacaoRepository irrigacaoRepository;
	@Autowired
	private FertilizanteRepository fertilizanteRepository;
	@Autowired
	private ColheitaRepository colheitaRepository;
	
	
	public void instantiateTestDatabase() throws ParseException  {
		
		Usuario user1 = new Usuario(null, "Marcio", "marcio@gmail.com", "123.432.123-56",TipoUsuario.PESSOAFISICA, pe.encode("123"));
		Usuario user2 = new Usuario(null, "Levi", "levi@gmail.com", "123.432.123-56",TipoUsuario.PESSOAJURIDICA, pe.encode("123"));
		Usuario user3 = new Usuario(null, "Luna", "luna@gmail.com", "123.432.123-56",TipoUsuario.PESSOAFISICA, pe.encode("123"));
		user1.addPerfil(Perfil.ADMIN);
		user2.addPerfil(Perfil.USUARIO);
		user3.addPerfil(Perfil.USUARIO);
		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
		
		//SistemaProducao sistema1 = new SistemaProducao(null,"Sisteminha",sdf.parse("10/04/2019 22:31"),100.0, 80.0, user1 );
		//SistemaProducao sistema2 = new SistemaProducao(null,"Sisteminha do IF",sdf.parse("10/04/2019 22:31"),50.0, 50.0, user1);
		//SistemaProducao sistema3 = new SistemaProducao(null,"Sisteminha três",sdf.parse("10/04/2019 22:31"),100.0, 80.0, user2);
		//SistemaProducao sistema4 = new SistemaProducao(null,"Sisteminha Quatro",sdf.parse("10/04/2019 22:31"),50.0, 50.0, user2);
		//SistemaProducao sistema5 = new SistemaProducao(null,"Sisteminha Cinco",sdf.parse("10/04/2019 22:31"),100.0, 80.0,user2);
		//SistemaProducao sistema6 = new SistemaProducao(null,"Sisteminha Seis",sdf.parse("10/04/2019 22:31"),50.0, 50.0,user3);
	
				
		//Canteiro canteiro1 = new Canteiro(null,"Canteiro do Repolho", 100.0, 20.0, sistema1);
		//Canteiro canteiro2 = new Canteiro(null,"Canteiro do Alface", 100.0, 20.0, sistema2);
		//Canteiro canteiro3 = new Canteiro(null,"Canteiro 1 de Levi", 100.0, 20.0, sistema3);
		
				
		//Criatorio criatorio1 = new Criatorio(null,"Tanque de Peixes",null,TipoCriatorio.TANQUE, 100.0, 20.0, 10.0, sistema1);
		//Criatorio criatorio2 = new Criatorio(null,"Poleiro das galinhas",null,TipoCriatorio.POLEIRO, 100.0, 20.0, 0.0, sistema1);
		//Criatorio criatorio3 = new Criatorio(null, "Chiqueiro 1",null, TipoCriatorio.CHIQUEIRO, 20.0, 10.0, 0.0, sistema6);
		
		
		//Grupo grupo1 = new Grupo(null, "Hortalícias");
		//Grupo grupo2 = new Grupo(null, "Grãos");
		Cultura cultura1 = new Cultura(null, "Abobrinha", 60);
		Cultura cultura2 = new Cultura(null, "Alface", 60);
		Cultura cultura3 = new Cultura(null, "Berinjela", 90);
		Cultura cultura4 = new Cultura(null, "Beterraba", 90);
		Cultura cultura5 = new Cultura(null, "Cebola", 120);
		Cultura cultura6 = new Cultura(null, "Cebolinha", 60);
		Cultura cultura7 = new Cultura(null, "Cenoura", 90);
		Cultura cultura8 = new Cultura(null, "Couve", 60);
		Cultura cultura9 = new Cultura(null, "Espinafre", 60);
		Cultura cultura10 = new Cultura(null, "Pepino", 60);
		Cultura cultura11 = new Cultura(null, "Pimentão", 90);
		Cultura cultura12 = new Cultura(null, "Quiabo", 60);
		Cultura cultura13 = new Cultura(null, "Rabanete", 30);
		Cultura cultura14 = new Cultura(null, "Repolho", 120);
		Cultura cultura15 = new Cultura(null, "Tomate", 120);
		Cultura cultura16 = new Cultura(null, "Coentro", 60);
		Cultura cultura17 = new Cultura(null, "Milho", 90);
		Cultura cultura18 = new Cultura(null, "Feijão", 90);
		Cultura cultura19 = new Cultura(null, "Salsa", 60);
		
		/*
		grupo1.getCulturas().addAll(Arrays.asList(cultura1, cultura2));
		grupo2.getCulturas().addAll(Arrays.asList(cultura3,cultura2));
		cultura1.getGrupos().addAll(Arrays.asList(grupo1));
		cultura2.getGrupos().addAll(Arrays.asList(grupo2));
		cultura3.getGrupos().addAll(Arrays.asList(grupo2));
		
		//Inserindo previsão de colheita:
		Calendar colheita = Calendar.getInstance();
		colheita.setTime(sdf.parse("07/05/2019 14:40")); 
		colheita.add(Calendar.DAY_OF_MONTH,cultura1.getTempo());
		
		
		Plantio plantio1 = new Plantio(null, "Cebolas", sdf.parse("13/02/2019 07:44"),colheita.getTime(), 50, StatusRetirada.DISPONIVEL, canteiro1, cultura1);
		Plantio plantio2 = new Plantio(null, "Coentro", sdf.parse("13/02/2019 07:48"),colheita.getTime(), 20, StatusRetirada.DISPONIVEL, canteiro2, cultura2);
		Plantio plantio3 = new Plantio(null, "Milho", sdf.parse("13/02/2019 07:48"), colheita.getTime(),20, StatusRetirada.DISPONIVEL, canteiro2, cultura3);
		Plantio plantio1Levi = new Plantio(null, "Milho", sdf.parse("02/05/2019 07:48"),colheita.getTime(), 20,StatusRetirada.DISPONIVEL, canteiro3, cultura3);
		Plantio plantio5 = new Plantio(null, "Milho", sdf.parse("13/02/2019 13:10"), colheita.getTime(),20, StatusRetirada.DISPONIVEL, canteiro3, cultura1);
		
		Fertilizante fertilizacao1 = new Fertilizante(null, "Adubo orgânico", sdf.parse("07/02/2019 12:58"), 2, plantio2);
		Fertilizante fertilizacao2 = new Fertilizante(null, "Adubo orgânico", sdf.parse("13/02/2019 12:58"), 2, plantio2);
		Fertilizante fertilizacao3 = new Fertilizante(null, "Adubo orgânico", sdf.parse("13/02/2019 13:00"), 2, plantio3);
		Fertilizante fertilizacao4 = new Fertilizante(null, "Adubo químico", sdf.parse("13/02/2019 13:00"), 2, plantio1);
		
		Irrigacao irrigacao1 = new Irrigacao(null, 2, sdf.parse("13/02/2019 13:00"), plantio1);
		Irrigacao irrigacao2 = new Irrigacao(null, 3, sdf.parse("13/02/2019 13:00"), plantio1);
		
		Colheita colheita1 = new Colheita(null, 23, sdf.parse("28/06/2019 10:46"), plantio1);
		
		Irrigacao irrigacao3 = new Irrigacao(null, sdf.parse("13/02/2019 13:00"), plantio2);
		Irrigacao irrigacao4 = new Irrigacao(null, sdf.parse("13/02/2019 13:00"), plantio3);
		
		Defensivo defensivo1 = new Defensivo(null, "Defensivo biológico", sdf.parse("13/02/2019 13:00"), 2, plantio1);
		Defensivo defensivo2 = new Defensivo(null, "Defensivo biológico", sdf.parse("13/02/2019 13:00"), 2, plantio2);
		Defensivo defensivo3 = new Defensivo(null, "Defensivo biológico", sdf.parse("13/02/2019 13:00"), 2, plantio3);
		
		plantio1.getFertilizantes().addAll(Arrays.asList(fertilizacao4));
		plantio2.getFertilizantes().addAll(Arrays.asList(fertilizacao1,fertilizacao2));
		plantio3.getFertilizantes().addAll(Arrays.asList(fertilizacao3));
		
		plantio1.getIrrigacoes().addAll(Arrays.asList(irrigacao1,irrigacao2));
		plantio2.getIrrigacoes().addAll(Arrays.asList(irrigacao3));
		plantio3.getIrrigacoes().addAll(Arrays.asList(irrigacao4));
		
		plantio1.getDefensivos().addAll(Arrays.asList(defensivo1));
		plantio2.getDefensivos().addAll(Arrays.asList(defensivo2));
		plantio3.getDefensivos().addAll(Arrays.asList(defensivo3));
		
		Animal animal1 = new Animal(null, "Galinha caipira", "Caipira", sdf.parse("11/02/2019 21:27") ,TipoAnimal.GALINHA, StatusRetirada.DISPONIVEL,criatorio2);
		Animal animal2 = new Animal(null, "Galinha Boa", "Caipira", sdf.parse("11/02/2019 21:28"), TipoAnimal.GALINHA, StatusRetirada.DISPONIVEL, criatorio2);
		Animal porquinhos = new Animal(null, "Porquinhos da índia", "Índia", sdf.parse("19/04/2019 22:57"), TipoAnimal.PORCO, StatusRetirada.DISPONIVEL, criatorio3);
			
		user1.getSistemas().addAll(Arrays.asList(sistema1,sistema2,sistema3));
		user2.getSistemas().addAll(Arrays.asList(sistema4,sistema5));
		user3.getSistemas().addAll(Arrays.asList(sistema6));
		criatorio2.getAnimais().addAll(Arrays.asList(animal1,animal2));
		criatorio3.getAnimais().addAll(Arrays.asList(porquinhos));*/
			
		usuarioRepository.saveAll(Arrays.asList(user1,user2,user3));
		/*
		sistemaProducaoRepository.saveAll(Arrays.asList(sistema1,sistema2,sistema3, sistema4, sistema5, sistema6));
		sistemaProducaoRepository.saveAll(Arrays.asList(sistema1,sistema2));
		canteiroRepository.saveAll(Arrays.asList(canteiro1,canteiro2));
		criatorioRepository.saveAll(Arrays.asList(criatorio1,criatorio2));
		animalRepository.saveAll(Arrays.asList(animal1,animal2));
		grupoRepository.saveAll(Arrays.asList(grupo1,grupo2));*/
		
		culturaRepository.saveAll(Arrays.asList(cultura1,cultura2,cultura3,cultura4,cultura5,cultura6,cultura7,cultura8,
		cultura9,cultura10,cultura11,cultura12,cultura13,cultura14,cultura15,cultura16,cultura17,cultura18,cultura19));
		
		/*plantioRepository.saveAll(Arrays.asList(plantio1,plantio2));
		irrigacaoRepository.saveAll(Arrays.asList(irrigacao1,irrigacao2));
		colheitaRepository.saveAll(Arrays.asList(colheita1));
		fertilizanteRepository.saveAll(Arrays.asList(fertilizacao1,fertilizacao2,fertilizacao3,fertilizacao4));
		defensivoRepository.saveAll(Arrays.asList(defensivo1,defensivo2,defensivo3));*/
		
	}
	
	
}
