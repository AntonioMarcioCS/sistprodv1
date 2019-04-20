package com.antoniomarciocs.sistprodv1.resources;

import java.net.URI;
import java.util.List;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.antoniomarciocs.sistprodv1.domain.Setor;
import com.antoniomarciocs.sistprodv1.dto.SetorDTO;
import com.antoniomarciocs.sistprodv1.services.SetorService;

@RestController
@RequestMapping(value="/setores")
public class SetorResource {

	@Autowired
	private  SetorService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Setor> find(@PathVariable Integer id) {
		Setor obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	//Pode da erro pq SetorDTO está sistemaId no lugar do objeto
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SetorDTO objDto){
		Setor obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody SetorDTO objDto,@PathVariable Integer id){
		Setor obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Setor> delete(@PathVariable Integer id) {
		service.delete(id);		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SetorDTO>> findAll() {
		List<Setor> list = service.buscarTodos();
		List<SetorDTO> listDto = list.stream().map(obj -> new SetorDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	/*
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<SetorDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Setor> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<SetorDTO> listDto = list.map(obj -> new SetorDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}*/
	
	/*Busca paginada de setores por nome e sistema
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<SetorDTO>> findPage(
			@RequestParam(value="nome", defaultValue="") String nome, 
			@RequestParam(value="sistema", defaultValue="") String sistema, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		String nomeDecoded = URL.decodeParam(nome);
		String id = URL.decodeParam(sistema);
		Page<Setor> list = service.search(nomeDecoded, Integer.parseInt(id), page, linesPerPage, orderBy, direction);
		Page<SetorDTO> listDto = list.map(obj -> new SetorDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}*/
	
	
}
