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


import com.antoniomarciocs.sistprodv1.domain.Irrigacao;
import com.antoniomarciocs.sistprodv1.dto.IrrigacaoDTO;
import com.antoniomarciocs.sistprodv1.resources.utils.URL;
import com.antoniomarciocs.sistprodv1.services.IrrigacaoService;

@RestController
@RequestMapping(value="/irrigacao")
public class IrrigacaoResource {

	@Autowired
	private IrrigacaoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Irrigacao> find(@PathVariable Integer id) {
		Irrigacao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody IrrigacaoDTO objDto) {
		Irrigacao obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<IrrigacaoDTO>> findPage(
			//@RequestParam(value="id", defaultValue="") String id, 
			@RequestParam(value="plantio", defaultValue="") String plantio, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="data") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		//String idDecoded = URL.decodeParam(id);
		List<Integer> ids = URL.decodeIntList(plantio);
		Page<Irrigacao> list = service.search(ids, page, linesPerPage, orderBy, direction);
		Page<IrrigacaoDTO> listDto = list.map(obj -> new IrrigacaoDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	
	
}
