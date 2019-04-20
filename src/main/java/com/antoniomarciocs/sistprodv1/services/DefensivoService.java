package com.antoniomarciocs.sistprodv1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.antoniomarciocs.sistprodv1.domain.Defensivo;
import com.antoniomarciocs.sistprodv1.domain.Plantio;
import com.antoniomarciocs.sistprodv1.repositories.DefensivoRepository;
import com.antoniomarciocs.sistprodv1.repositories.PlantioRepository;
import com.antoniomarciocs.sistprodv1.services.exceptions.ObjectNotFountException;

@Service
public class DefensivoService {

	
	@Autowired
	private DefensivoRepository defensivoRepo;
	
	@Autowired
	private PlantioRepository plantioRepo;
	
	public Defensivo find(Integer id) {
		Optional<Defensivo> obj = defensivoRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Defensivo.class.getName()));
	}

	public Page<Defensivo> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Plantio> plantio = plantioRepo.findAllById(ids);
		return defensivoRepo.findDistinctByNomeContainingAndPlantioIn(nome,plantio, pageRequest);	
	}
	
	public Defensivo insert(Defensivo obj) {
		obj.setId(null);
		return defensivoRepo.save(obj);
	}

	
	public Defensivo update(Defensivo obj) {
		Defensivo newObj = find(obj.getId());
		atualizaDados(newObj, obj);
		return defensivoRepo.save(newObj);
	}
	
	private void atualizaDados(Defensivo newObj, Defensivo obj) {
		newObj.setNome(obj.getNome());
		newObj.setPlantio(obj.getPlantio());
	}
}
