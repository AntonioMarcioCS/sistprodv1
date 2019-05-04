package com.antoniomarciocs.sistprodv1.resources;

import java.net.URI;

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

import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;
import com.antoniomarciocs.sistprodv1.dto.SisteminhaDTO;
import com.antoniomarciocs.sistprodv1.services.SisteminhaService;

@RestController
@RequestMapping(value="/sisteminhas")
public class SisteminhaResource {

	@Autowired
	private  SisteminhaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<SistemaProducao> find(@PathVariable Integer id) {
		SistemaProducao obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SisteminhaDTO objDto){
		SistemaProducao obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/*
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SistemaProducao obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}*/
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody SisteminhaDTO objDto,@PathVariable Integer id){
		SistemaProducao obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<SistemaProducao> delete(@PathVariable Integer id) {
		service.delete(id);		
		return ResponseEntity.noContent().build();
	}
	
	//Tirei o findAll p testar o findPage. os dois tem o mesmo mapeamento
	/*@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SistemaProducaoDTO>> findAll() {
		List<SistemaProducao> list = service.buscarTodos();
		List<SistemDTO> listDto = list.stream().map(obj -> new SistemaProducaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}*/
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<SisteminhaDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="DESC") String direction) {
		Page<SisteminhaDTO> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
}
