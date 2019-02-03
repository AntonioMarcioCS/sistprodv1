package com.antoniomarciocs.sistprodv1.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;
import com.antoniomarciocs.sistprodv1.services.SistemaProducaoService;

@RestController
@RequestMapping(value="/sistemas")
public class SistemaProducaoResource {

	@Autowired
	private  SistemaProducaoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		SistemaProducao obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
