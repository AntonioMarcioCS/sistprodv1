package com.antoniomarciocs.sistprodv1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.antoniomarciocs.sistprodv1.domain.Canteiro;
import com.antoniomarciocs.sistprodv1.domain.Setor;
import com.antoniomarciocs.sistprodv1.repositories.CanteiroRepository;
import com.antoniomarciocs.sistprodv1.repositories.SetorRepository;
import com.antoniomarciocs.sistprodv1.services.exceptions.ObjectNotFountException;

@Service
public class CanteiroService {

	
	@Autowired
	private CanteiroRepository canteiroRepo;
	
	@Autowired
	private SetorRepository setorRepo;
	
	public Canteiro find(Integer id) {
		Optional<Canteiro> obj = canteiroRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Canteiro.class.getName()));
	}

	public Page<Canteiro> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Setor> setores = setorRepo.findAllById(ids);
		return canteiroRepo.findDistinctByNomeContainingAndSestoresIn(nome, setores, pageRequest);	
	}
	
	public Canteiro insert(Canteiro obj) {
		obj.setId(null);
		return canteiroRepo.save(obj);
	}

	
	public Canteiro update(Canteiro obj) {
		Canteiro newObj = find(obj.getId());
		atualizaDados(newObj, obj);
		return canteiroRepo.save(newObj);
	}
	
	private void atualizaDados(Canteiro newObj, Canteiro obj) {
		newObj.setNome(obj.getNome());
		newObj.setSetor(obj.getSetor());
	}
}
