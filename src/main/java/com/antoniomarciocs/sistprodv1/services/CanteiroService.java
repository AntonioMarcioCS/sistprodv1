package com.antoniomarciocs.sistprodv1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.antoniomarciocs.sistprodv1.domain.Canteiro;
import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;
import com.antoniomarciocs.sistprodv1.dto.CanteiroDTO;
import com.antoniomarciocs.sistprodv1.repositories.CanteiroRepository;
import com.antoniomarciocs.sistprodv1.repositories.SistemaProducaoRepository;
import com.antoniomarciocs.sistprodv1.services.exceptions.ObjectNotFountException;

@Service
public class CanteiroService {

	
	@Autowired
	private CanteiroRepository canteiroRepo;
	
	@Autowired
	private SistemaProducaoRepository sistemaRepo;
	
	@Autowired
	private SistemaProducaoService sistemaService;
	
	public Canteiro find(Integer id) {
		Optional<Canteiro> obj = canteiroRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Canteiro.class.getName()));
	}
	

	public List<Canteiro> findBySistema(Integer sistemaId) {
		return canteiroRepo.findCanteiros(sistemaId);
	}
	
	public Canteiro fromDTO(CanteiroDTO objDTO) {
		SistemaProducao sistema = sistemaService.buscar(objDTO.getSistemaId());
		return new Canteiro(objDTO.getId(),objDTO.getNome(),objDTO.getComprimento(), objDTO.getLargura(), sistema);
	}
	
	public Page<Canteiro> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<SistemaProducao> sistemas = sistemaRepo.findAllById(ids);
		return canteiroRepo.findDistinctByNomeContainingAndSistemasIn(nome, sistemas, pageRequest);	
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
		newObj.setSistema(obj.getSistema());
	}
}
