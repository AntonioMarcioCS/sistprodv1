package com.antoniomarciocs.sistprodv1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.antoniomarciocs.sistprodv1.domain.Setor;
import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;
import com.antoniomarciocs.sistprodv1.dto.SetorDTO;
import com.antoniomarciocs.sistprodv1.repositories.SetorRepository;
import com.antoniomarciocs.sistprodv1.repositories.SistemaProducaoRepository;
import com.antoniomarciocs.sistprodv1.services.exceptions.DataIntegrityException;
import com.antoniomarciocs.sistprodv1.services.exceptions.ObjectNotFountException;

@Service
public class SetorService {

	
	@Autowired
	private SetorRepository repo;
	
	@Autowired
	private SistemaProducaoRepository sistemaRepo;
	
	public Setor buscar(Integer id){
		Optional<Setor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException("Objeto não encontrado! ID:"+id+ " Nome:"
		+Setor.class.getName()));
	}
	
	public Setor insert(Setor obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Setor update(Setor obj) {
		Setor newObj = buscar(obj.getId());
		atualizaDados(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		buscar(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um usuário com dependências");
		}
	}
	
	public List<Setor> buscarTodos(){
		return repo.findAll();
	}
	
	public Page<Setor> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		return repo.findAll(pageRequest);	
	}
	
	public Page<Setor> search(String nome, Integer id, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Optional<SistemaProducao> sistema = sistemaRepo.findById(id);
		return repo.findDistinctByNomeContainingAndSistemaProducaoIn(nome, sistema, pageRequest);	
	}
	
	public Setor fromDTO(SetorDTO objDTO) {
		SistemaProducao sist = sistemaRepo.getOne(objDTO.getSistemaId());
		Setor setor = new Setor(objDTO.getId(), objDTO.getNome(), objDTO.getRegiao(), sist);
		return setor;
	}
	
	private void atualizaDados(Setor newObj, Setor obj) {
		newObj.setNome(obj.getNome());
		newObj.setRegiao(obj.getRegiao());
	}
}
