package com.antoniomarciocs.sistprodv1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.antoniomarciocs.sistprodv1.domain.Fertilizante;
import com.antoniomarciocs.sistprodv1.domain.Plantio;
import com.antoniomarciocs.sistprodv1.repositories.FertilizanteRepository;
import com.antoniomarciocs.sistprodv1.repositories.PlantioRepository;
import com.antoniomarciocs.sistprodv1.services.exceptions.ObjectNotFountException;

@Service
public class FertilizanteService {

	
	@Autowired
	private FertilizanteRepository fertilizanteRepo;
	
	@Autowired
	private PlantioRepository plantioRepo;
	
	public Fertilizante find(Integer id) {
		Optional<Fertilizante> obj = fertilizanteRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Fertilizante.class.getName()));
	}

	public Page<Fertilizante> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Plantio> plantio = plantioRepo.findAllById(ids);
		return fertilizanteRepo.findDistinctByNomeContainingAndPlantioIn(nome,plantio, pageRequest);	
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
		newObj.setNome(obj.getNome());
		newObj.setPlantio(obj.getPlantio());
	}
}
