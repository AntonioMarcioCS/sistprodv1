package com.antoniomarciocs.sistprodv1.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.antoniomarciocs.sistprodv1.domain.Canteiro;
import com.antoniomarciocs.sistprodv1.domain.Criatorio;
import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;
import com.antoniomarciocs.sistprodv1.dto.CanteiroDTO;
import com.antoniomarciocs.sistprodv1.dto.CriatorioDTO;
import com.antoniomarciocs.sistprodv1.dto.SistemaProducaoDTO;
import com.antoniomarciocs.sistprodv1.services.CanteiroService;
import com.antoniomarciocs.sistprodv1.services.CriatorioService;
import com.antoniomarciocs.sistprodv1.services.SistemaProducaoService;

@RestController
@RequestMapping(value="/sistemas")
public class SistemaProducaoResource {

	@Autowired
	private  SistemaProducaoService service;
	
	@Autowired
	private CanteiroService canteiroService;
	
	@Autowired
	private CriatorioService criatorioService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<SistemaProducao> find(@PathVariable Integer id) {
		SistemaProducao obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{sistemaId}/canteiros", method=RequestMethod.GET)
	public ResponseEntity<List<CanteiroDTO>> findCanteiros(@PathVariable Integer sistemaId){
		List<Canteiro> list = canteiroService.findBySistema(sistemaId);
		List<CanteiroDTO> listDto = list.stream().map(obj -> new CanteiroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	@RequestMapping(value="/{sistemaId}/criatorios", method=RequestMethod.GET)
	public ResponseEntity<List<CriatorioDTO>> findCriatorios(@PathVariable Integer sistemaId){
		List<Criatorio> list = criatorioService.findBySistema(sistemaId);
		List<CriatorioDTO> listDto = list.stream().map(obj -> new CriatorioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SistemaProducaoDTO objDto){
		SistemaProducao obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
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
	public ResponseEntity<Void> update(@Valid @RequestBody SistemaProducaoDTO objDto,@PathVariable Integer id){
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
	///@PreAuthorize("hasAnyRole('ADMIN')")
	/*@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SistemaProducaoDTO>> findAll() {
		List<SistemaProducao> list = service.buscarTodos();
		List<SistemaProducaoDTO> listDto = list.stream().map(obj -> new SistemaProducaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}*/
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<SistemaProducaoDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="DESC") String direction) {
		Page<SistemaProducao> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<SistemaProducaoDTO> listDto = list.map(obj -> new SistemaProducaoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
		
}
