package com.antoniomarciocs.sistprodv1.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;

@RestController
@RequestMapping(value="/sistemas")
public class SistemaProducaoResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<SistemaProducao> listar() {
		
		SistemaProducao sist1 = new SistemaProducao(1,"Sisteminha Teste",100.0,100.0);
		SistemaProducao sist2 = new SistemaProducao(2,"Sisteminha IF",100.0,100.0);
		
		List<SistemaProducao> lista = new ArrayList<>();
		lista.add(sist1);
		lista.add(sist2);
		return lista;
	}
}
