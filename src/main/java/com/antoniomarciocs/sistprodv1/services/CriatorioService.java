package com.antoniomarciocs.sistprodv1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.antoniomarciocs.sistprodv1.domain.Criatorio;
import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;
import com.antoniomarciocs.sistprodv1.repositories.CriatorioRepository;
import com.antoniomarciocs.sistprodv1.repositories.SistemaProducaoRepository;
import com.antoniomarciocs.sistprodv1.services.exceptions.ObjectNotFountException;

@Service
public class CriatorioService {

	
	@Autowired
	private CriatorioRepository criatorioRepo;
	
	@Autowired
	private SistemaProducaoRepository sistemaRepo;
	
	public Criatorio find(Integer id) {
		Optional<Criatorio> obj = criatorioRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Criatorio.class.getName()));
	}
	
	public List<Criatorio> findBySistema(Integer sistemaId) {
		return criatorioRepo.findCriatorios(sistemaId);
	}
	
	public Page<Criatorio> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<SistemaProducao> sistemas = sistemaRepo.findAllById(ids);
		return criatorioRepo.findDistinctByNomeContainingAndSistemasIn(nome, sistemas, pageRequest);	
	}
	
	public Criatorio insert(Criatorio obj) {
		obj.setId(null);
		return criatorioRepo.save(obj);
	}

	
	public Criatorio update(Criatorio obj) {
		Criatorio newObj = find(obj.getId());
		atualizaDados(newObj, obj);
		return criatorioRepo.save(newObj);
	}
	
	private void atualizaDados(Criatorio newObj, Criatorio obj) {
		newObj.setNome(obj.getNome());
		newObj.setSistema(obj.getSistema());
	}
}
