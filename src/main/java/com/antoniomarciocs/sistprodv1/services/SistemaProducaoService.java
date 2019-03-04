package com.antoniomarciocs.sistprodv1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;
import com.antoniomarciocs.sistprodv1.repositories.SistemaProducaoRepository;
import com.antoniomarciocs.sistprodv1.services.exceptions.DataIntegrityException;
import com.antoniomarciocs.sistprodv1.services.exceptions.ObjectNotFountException;

@Service
public class SistemaProducaoService {

	@Autowired
	private SistemaProducaoRepository repo; 
	
	public SistemaProducao buscar(Integer id){
		Optional<SistemaProducao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException("Objeto não encontrado! ID:"+id+ " Nome:"
		+SistemaProducao.class.getName()));
	}
	
	public SistemaProducao insert(SistemaProducao obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public SistemaProducao update(SistemaProducao obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		buscar(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Sistema, ele possui várias dependências");
		}
	}
	
	public List<SistemaProducao> buscarTodos(){
		return repo.findAll();
	}
	
}
