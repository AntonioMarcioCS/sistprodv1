package com.antoniomarciocs.sistprodv1.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.antoniomarciocs.sistprodv1.domain.Animal;
import com.antoniomarciocs.sistprodv1.domain.Canteiro;
import com.antoniomarciocs.sistprodv1.domain.Criatorio;
import com.antoniomarciocs.sistprodv1.domain.Cultura;
import com.antoniomarciocs.sistprodv1.domain.Defensivo;
import com.antoniomarciocs.sistprodv1.domain.Fertilizante;
import com.antoniomarciocs.sistprodv1.domain.Grupo;
import com.antoniomarciocs.sistprodv1.domain.Irrigacao;
import com.antoniomarciocs.sistprodv1.domain.Plantio;
import com.antoniomarciocs.sistprodv1.domain.Setor;
import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;
import com.antoniomarciocs.sistprodv1.domain.Usuario;
import com.antoniomarciocs.sistprodv1.domain.enums.StatusRetirada;
import com.antoniomarciocs.sistprodv1.domain.enums.TipoAnimal;
import com.antoniomarciocs.sistprodv1.repositories.AnimalRepository;
import com.antoniomarciocs.sistprodv1.repositories.CanteiroRepository;
import com.antoniomarciocs.sistprodv1.repositories.CriatorioRepository;
import com.antoniomarciocs.sistprodv1.repositories.CulturaRepository;
import com.antoniomarciocs.sistprodv1.repositories.DefensivoRepository;
import com.antoniomarciocs.sistprodv1.repositories.FertilizanteRepository;
import com.antoniomarciocs.sistprodv1.repositories.GrupoRepository;
import com.antoniomarciocs.sistprodv1.repositories.IrrigacaoRepository;
import com.antoniomarciocs.sistprodv1.repositories.PlantioRepository;
import com.antoniomarciocs.sistprodv1.repositories.SetorRepository;
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
	private SetorRepository setorRepository;
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
	
	public void instantiateTestDatabase() throws ParseException  {
		
		Usuario user1 = new Usuario(null, "Marcio", "marcio@gmail.com", "123.432.123-56", pe.encode("123"));
		Usuario user2 = new Usuario(null, "Levi", "levi@gmail.com", "123.432.123-56", pe.encode("123"));
		
		SistemaProducao sistema1 = new SistemaProducao(null,"Sisteminha",100.0, 80.0, user1 );
		SistemaProducao sistema2 = new SistemaProducao(null,"Sisteminha do IF",50.0, 50.0, user1);
		SistemaProducao sistema3 = new SistemaProducao(null,"Sisteminha três",100.0, 80.0, user1);
		SistemaProducao sistema4 = new SistemaProducao(null,"Sisteminha Quatro",50.0, 50.0, user2);
		SistemaProducao sistema5 = new SistemaProducao(null,"Sisteminha Cinco",100.0, 80.0,user2);
		SistemaProducao sistema6 = new SistemaProducao(null,"Sisteminha Seis",50.0, 50.0,user2);
	
		Setor setor1 = new Setor(null,"Hortalícias","Sul", sistema1);
		Setor setor2 = new Setor(null,"Galinhas","Norte", sistema2);
		
		Canteiro canteiro1 = new Canteiro(null,"Canteiro do Repolho", 100.0, 20.0, setor1);
		Canteiro canteiro2 = new Canteiro(null,"Canteiro do Alface", 100.0, 20.0, setor1);
				
		Criatorio criatorio1 = new Criatorio(null,"Tanque de Peixes", 100.0, 20.0, 10.0, setor2);
		Criatorio criatorio2 = new Criatorio(null,"Poleiro das galinhas", 100.0, 20.0, 0.0, setor2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
		
		Grupo grupo1 = new Grupo(null, "Hortalícias");
		Grupo grupo2 = new Grupo(null, "Grãos");
		Cultura cultura1 = new Cultura(null, "Cebola");
		Cultura cultura2 = new Cultura(null, "Coentro");
		Cultura cultura3 = new Cultura(null, "Milho");
				
		grupo1.getCulturas().addAll(Arrays.asList(cultura1, cultura2));
		grupo2.getCulturas().addAll(Arrays.asList(cultura3));
		cultura1.getGrupos().addAll(Arrays.asList(grupo1));
		cultura2.getGrupos().addAll(Arrays.asList(grupo2));
		
		
		Plantio plantio1 = new Plantio(null, "Cebolas", sdf.parse("13/02/2019 07:44"), 50, StatusRetirada.DISPONIVEL, canteiro1, cultura1);
		Plantio plantio2 = new Plantio(null, "Coentro", sdf.parse("13/02/2019 07:48"), 20, StatusRetirada.DISPONIVEL, canteiro2, cultura2);
		Plantio plantio3 = new Plantio(null, "Milho", sdf.parse("13/02/2019 07:48"), 20, StatusRetirada.DISPONIVEL, canteiro2, cultura3);
		
		Fertilizante fertilizacao1 = new Fertilizante(null, "Adubo orgânico", sdf.parse("07/02/2019 12:58"), 2, plantio2);
		Fertilizante fertilizacao2 = new Fertilizante(null, "Adubo orgânico", sdf.parse("13/02/2019 12:58"), 2, plantio2);
		Fertilizante fertilizacao3 = new Fertilizante(null, "Adubo orgânico", sdf.parse("13/02/2019 13:00"), 2, plantio3);
		Fertilizante fertilizacao4 = new Fertilizante(null, "Adubo químico", sdf.parse("13/02/2019 13:00"), 2, plantio1);
		Irrigacao irrigacao1 = new Irrigacao(null, sdf.parse("13/02/2019 13:00"), plantio1);
		Irrigacao irrigacao2 = new Irrigacao(null, sdf.parse("13/02/2019 13:00"), plantio1);
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
			
		user1.getSistemas().addAll(Arrays.asList(sistema1,sistema2,sistema3));
		user2.getSistemas().addAll(Arrays.asList(sistema4,sistema5,sistema6));
		sistema1.getSetores().addAll(Arrays.asList(setor1,setor2));
		setor1.getCanteiros().addAll(Arrays.asList(canteiro1,canteiro2));
		setor2.getCriatorios().addAll(Arrays.asList(criatorio1,criatorio2));
		criatorio2.getAnimais().addAll(Arrays.asList(animal1,animal2));
			
		usuarioRepository.saveAll(Arrays.asList(user1,user2));
		sistemaProducaoRepository.saveAll(Arrays.asList(sistema1,sistema2,sistema3, sistema4, sistema5, sistema6));
		setorRepository.saveAll(Arrays.asList(setor1,setor2));
		canteiroRepository.saveAll(Arrays.asList(canteiro1,canteiro2));
		criatorioRepository.saveAll(Arrays.asList(criatorio1,criatorio2));
		animalRepository.saveAll(Arrays.asList(animal1,animal2));
		grupoRepository.saveAll(Arrays.asList(grupo1,grupo2));
		culturaRepository.saveAll(Arrays.asList(cultura1,cultura2,cultura3));
		
		plantioRepository.saveAll(Arrays.asList(plantio1,plantio2,plantio3));
		irrigacaoRepository.saveAll(Arrays.asList(irrigacao1,irrigacao2,irrigacao3,irrigacao4));
		fertilizanteRepository.saveAll(Arrays.asList(fertilizacao1,fertilizacao2,fertilizacao3,fertilizacao4));
		defensivoRepository.saveAll(Arrays.asList(defensivo1,defensivo2,defensivo3));
		
	}
	
	
}
