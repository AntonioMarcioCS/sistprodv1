package com.antoniomarciocs.sistprodv1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.antoniomarciocs.sistprodv1.domain.Irrigacao;
import com.antoniomarciocs.sistprodv1.domain.Plantio;
import com.antoniomarciocs.sistprodv1.repositories.IrrigacaoRepository;
import com.antoniomarciocs.sistprodv1.repositories.PlantioRepository;
import com.antoniomarciocs.sistprodv1.services.exceptions.ObjectNotFountException;

@Service
public class IrrigacaoService {
	
	@Autowired
	private IrrigacaoRepository irrigacaoRepo;
	
	@Autowired
	private PlantioRepository plantioRepo;
	
	public Irrigacao find(Integer id) {
		Optional<Irrigacao> obj = irrigacaoRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Irrigacao.class.getName()));
	}

	public Page<Irrigacao> search(String id, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Plantio> plantio = plantioRepo.findAllById(ids);
		return irrigacaoRepo.findDistinctByNomeContainingAndPlantioIn(id,plantio, pageRequest);	
	}
	
	public Irrigacao insert(Irrigacao obj) {
		obj.setId(null);
		return irrigacaoRepo.save(obj);
	}
	
	public Irrigacao update(Irrigacao obj) {
		Irrigacao newObj = find(obj.getId());
		atualizaDados(newObj, obj);
		return irrigacaoRepo.save(newObj);
	}
	
	private void atualizaDados(Irrigacao newObj, Irrigacao obj) {
		newObj.setId(obj.getId());
		newObj.setPlantio(obj.getPlantio());
	}
}
