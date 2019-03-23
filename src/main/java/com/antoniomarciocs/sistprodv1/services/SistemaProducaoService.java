package com.antoniomarciocs.sistprodv1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;
import com.antoniomarciocs.sistprodv1.domain.Usuario;
import com.antoniomarciocs.sistprodv1.dto.SistemaNewDTO;
import com.antoniomarciocs.sistprodv1.dto.SistemaProducaoDTO;
import com.antoniomarciocs.sistprodv1.repositories.SistemaProducaoRepository;
import com.antoniomarciocs.sistprodv1.repositories.UsuarioRepository;
import com.antoniomarciocs.sistprodv1.services.exceptions.DataIntegrityException;
import com.antoniomarciocs.sistprodv1.services.exceptions.ObjectNotFountException;

@Service
public class SistemaProducaoService {

	@Autowired
	private SistemaProducaoRepository repo; 
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
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
		SistemaProducao newObj = buscar(obj.getId());
		atualizaDados(newObj, obj);
		return repo.save(newObj);
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
	
	public Page<SistemaProducao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		return repo.findAll(pageRequest);		
	}
	
	public SistemaProducao fromDTO(SistemaProducaoDTO objDTO) {
		return new SistemaProducao(objDTO.getId(), objDTO.getNome(), objDTO.getComprimento(), objDTO.getLargura(), objDTO.getUsuario());
	}
	
	//testando:
	public SistemaProducao fromDTO(SistemaNewDTO objDTO) {
		Usuario user = usuarioRepository.getOne(objDTO.getUsuarioId());
		SistemaProducao sistema = new SistemaProducao(objDTO.getId(), objDTO.getNome(), objDTO.getComprimento(), objDTO.getLargura(), user);
		return sistema;
	}
	
	
	private void atualizaDados(SistemaProducao newObj, SistemaProducao obj) {
		newObj.setNome(obj.getNome());
		newObj.setComprimento(obj.getComprimento());
		newObj.setLargura(obj.getLargura());
	}
	
}
