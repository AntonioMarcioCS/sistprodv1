package com.antoniomarciocs.sistprodv1.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.antoniomarciocs.sistprodv1.domain.Criatorio;
import com.antoniomarciocs.sistprodv1.dto.CriatorioDTO;
import com.antoniomarciocs.sistprodv1.resources.utils.URL;
import com.antoniomarciocs.sistprodv1.services.CriatorioService;

@RestController
@RequestMapping(value="/criatorios")
public class CriatorioResource {

	@Autowired
	private CriatorioService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Criatorio> find(@PathVariable Integer id) {
		Criatorio obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Criatorio obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<CriatorioDTO>> findPage(
			@RequestParam(value="nome", defaultValue="") String nome, 
			@RequestParam(value="sistemas", defaultValue="") String sistemas, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		String nomeDecoded = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(sistemas);
		Page<Criatorio> list = service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
		Page<CriatorioDTO> listDto = list.map(obj -> new CriatorioDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	
	
}
