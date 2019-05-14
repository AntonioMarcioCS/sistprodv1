package com.antoniomarciocs.sistprodv1.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.antoniomarciocs.sistprodv1.domain.Canteiro;
import com.antoniomarciocs.sistprodv1.domain.Cultura;
import com.antoniomarciocs.sistprodv1.domain.Plantio;
import com.antoniomarciocs.sistprodv1.domain.enums.StatusRetirada;
import com.antoniomarciocs.sistprodv1.dto.PlantioDTO;
import com.antoniomarciocs.sistprodv1.repositories.CanteiroRepository;
import com.antoniomarciocs.sistprodv1.repositories.PlantioRepository;
import com.antoniomarciocs.sistprodv1.services.exceptions.ObjectNotFountException;

@Service
public class PlantioService {

	@Autowired
	private PlantioRepository plantioRepo;
	
	@Autowired
	private CanteiroRepository canteiroRepo;
	
	@Autowired
	private CanteiroService canteiroService;
	
	@Autowired
	private CulturaService culturaService;

	public Plantio find(Integer id) {
		Optional<Plantio> obj = plantioRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Plantio.class.getName()));
	}
	
	public List<Plantio> findByCanteiro(Integer canteiroId) {
		return plantioRepo.findPlantios(canteiroId);
	}
	
	public Plantio fromDTO(PlantioDTO objDTO) {
		Canteiro canteiro = canteiroService.find(objDTO.getCanteiroId());
		Cultura cultura = culturaService.find(objDTO.getCulturaId());
		objDTO.setData(new Date());
		Calendar colheita = Calendar.getInstance();
		colheita.setTime(objDTO.getData()); 
		colheita.add(Calendar.DAY_OF_MONTH,cultura.getTempo());
		return new Plantio(objDTO.getId(),objDTO.getNome(),objDTO.getData(), colheita.getTime(), objDTO.getQtd(), StatusRetirada.DISPONIVEL, canteiro, cultura);
	}
	
	public Page<Plantio> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Canteiro> canteiros = canteiroRepo.findAllById(ids);
		return plantioRepo.findDistinctByNomeContainingAndCanteirosIn(nome, canteiros, pageRequest);	
	}
	
	public Plantio insert(Plantio obj) {
		obj.setId(null);
		return plantioRepo.save(obj);
	}
	
	public Plantio update(Plantio obj) {
		Plantio newObj = find(obj.getId());
		atualizaDados(newObj, obj);
		return plantioRepo.save(newObj);
	}
	
	private void atualizaDados(Plantio newObj, Plantio obj) {
		newObj.setNome(obj.getNome());
		newObj.setCanteiro(obj.getCanteiro());
		newObj.setCultura(obj.getCultura());
	}
}
