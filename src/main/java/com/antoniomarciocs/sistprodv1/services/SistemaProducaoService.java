package com.antoniomarciocs.sistprodv1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;
import com.antoniomarciocs.sistprodv1.repositories.SistemaProducaoRepository;

@Service
public class SistemaProducaoService {

	@Autowired
	private SistemaProducaoRepository repo; 
	
	public SistemaProducao buscar(Integer id) {
		Optional<SistemaProducao> obj = repo.findById(id);
		return  obj.orElse(null);
	}
}
