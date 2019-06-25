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


import com.antoniomarciocs.sistprodv1.domain.Fertilizante;
import com.antoniomarciocs.sistprodv1.dto.FertilizanteDTO;
import com.antoniomarciocs.sistprodv1.resources.utils.URL;
import com.antoniomarciocs.sistprodv1.services.FertilizanteService;

@RestController
@RequestMapping(value="/fertilizantes")
public class FertilizanteResource {

	@Autowired
	private FertilizanteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Fertilizante> find(@PathVariable Integer id) {
		Fertilizante obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody FertilizanteDTO objDto) {
		Fertilizante obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<FertilizanteDTO>> findPage(
			@RequestParam(value="plantio", defaultValue="") String plantio, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="data") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		List<Integer> ids = URL.decodeIntList(plantio);
		Page<Fertilizante> list = service.search(ids, page, linesPerPage, orderBy, direction);
		Page<FertilizanteDTO> listDto = list.map(obj -> new FertilizanteDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	
	
}
