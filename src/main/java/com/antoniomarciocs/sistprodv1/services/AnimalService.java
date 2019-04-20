package com.antoniomarciocs.sistprodv1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.antoniomarciocs.sistprodv1.domain.Animal;
import com.antoniomarciocs.sistprodv1.domain.Criatorio;
import com.antoniomarciocs.sistprodv1.repositories.AnimalRepository;
import com.antoniomarciocs.sistprodv1.repositories.CriatorioRepository;
import com.antoniomarciocs.sistprodv1.services.exceptions.ObjectNotFountException;

@Service
public class AnimalService {

	
	@Autowired
	private AnimalRepository animalRepo;
	
	@Autowired
	private CriatorioRepository criatorioRepo;
	
	public Animal find(Integer id) {
		Optional<Animal> obj = animalRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Animal.class.getName()));
	}

	public Page<Animal> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Criatorio> criatorio = criatorioRepo.findAllById(ids);
		return animalRepo.findDistinctByNomeContainingAndCriatorioIn(nome,criatorio, pageRequest);	
	}
	
	public Animal insert(Animal obj) {
		obj.setId(null);
		return animalRepo.save(obj);
	}

	
	public Animal update(Animal obj) {
		Animal newObj = find(obj.getId());
		atualizaDados(newObj, obj);
		return animalRepo.save(newObj);
	}
	
	private void atualizaDados(Animal newObj, Animal obj) {
		newObj.setNome(obj.getNome());
		newObj.setCriatorio(obj.getCriatorio());
	}
}
