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
import com.antoniomarciocs.sistprodv1.domain.Fertilizante;
import com.antoniomarciocs.sistprodv1.domain.Plantio;
import com.antoniomarciocs.sistprodv1.dto.FertilizanteDTO;
import com.antoniomarciocs.sistprodv1.repositories.FertilizanteRepository;
import com.antoniomarciocs.sistprodv1.repositories.PlantioRepository;
import com.antoniomarciocs.sistprodv1.services.exceptions.ObjectNotFountException;

@Service
public class FertilizanteService {

	
	@Autowired
	private FertilizanteRepository fertilizanteRepo;
	
	@Autowired
	private PlantioRepository plantioRepo;
	
	@Autowired
	private PlantioService plantioService;
	
	public Fertilizante find(Integer id) {
		Optional<Fertilizante> obj = fertilizanteRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Fertilizante.class.getName()));
	}
	
	public Fertilizante fromDTO(FertilizanteDTO objDTO) {
		Plantio plantio = plantioService.find(objDTO.getPlantioId());
		objDTO.setData(new Date());
		Calendar data = Calendar.getInstance();
		data.setTime(objDTO.getData()); 
		return new Fertilizante(objDTO.getId(),objDTO.getData(), objDTO.getDescricao(), objDTO.getQtd(), plantio);
	}

	public Page<Fertilizante> search(List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Plantio> plantio = plantioRepo.findAllById(ids);
		return fertilizanteRepo.findDistinctByIdContainingAndPlantioIn(plantio, pageRequest);	
	}
	
	
	public Fertilizante insert(Fertilizante obj) {
		obj.setId(null);
		return fertilizanteRepo.save(obj);
	}

	
	public Fertilizante update(Fertilizante obj) {
		Fertilizante newObj = find(obj.getId());
		atualizaDados(newObj, obj);
		return fertilizanteRepo.save(newObj);
	}
	
	private void atualizaDados(Fertilizante newObj, Fertilizante obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setPlantio(obj.getPlantio());
	}
}
