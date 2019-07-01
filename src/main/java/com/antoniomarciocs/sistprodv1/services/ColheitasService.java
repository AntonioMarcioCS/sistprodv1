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

import com.antoniomarciocs.sistprodv1.domain.Colheita;
import com.antoniomarciocs.sistprodv1.domain.Plantio;
import com.antoniomarciocs.sistprodv1.dto.ColheitaDTO;
import com.antoniomarciocs.sistprodv1.repositories.ColheitaRepository;
import com.antoniomarciocs.sistprodv1.repositories.PlantioRepository;
import com.antoniomarciocs.sistprodv1.services.exceptions.ObjectNotFountException;

@Service
public class ColheitasService {
	
	@Autowired
	private ColheitaRepository colheitaRepo;
	@Autowired
	private PlantioRepository plantioRepo;
	@Autowired
	private PlantioService plantioService;

	public Colheita find(Integer id) {
		Optional<Colheita> obj = colheitaRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Colheita.class.getName()));
	}
	
	public Colheita fromDTO(ColheitaDTO objDTO) {
		Plantio plantio = plantioService.find(objDTO.getPlantioId());
		objDTO.setData(new Date());
		Calendar data = Calendar.getInstance();
		data.setTime(objDTO.getData()); 
		return new Colheita(objDTO.getId(),objDTO.getQtd() ,objDTO.getData(), plantio);
	}
	
	public Page<Colheita> search(List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Plantio> plantio = plantioRepo.findAllById(ids);
		return colheitaRepo.findDistinctByIdContainingAndPlantioIn(plantio, pageRequest);	
	}
	
	public Colheita insert(Colheita obj) {
		obj.setId(null);
		return colheitaRepo.save(obj);
	}
	
	public Colheita update(Colheita obj) {
		Colheita newObj = find(obj.getId());
		atualizaDados(newObj, obj);
		return colheitaRepo.save(newObj);
	}
	
	private void atualizaDados(Colheita newObj, Colheita obj) {
		newObj.setId(obj.getId());
		newObj.setPlantio(obj.getPlantio());
	}
}
