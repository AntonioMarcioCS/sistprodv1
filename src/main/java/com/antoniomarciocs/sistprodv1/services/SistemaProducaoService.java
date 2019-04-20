package com.antoniomarciocs.sistprodv1.services;

import java.util.Date;
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
import com.antoniomarciocs.sistprodv1.security.UserSS;
import com.antoniomarciocs.sistprodv1.services.exceptions.AuthorizationException;
import com.antoniomarciocs.sistprodv1.services.exceptions.DataIntegrityException;
import com.antoniomarciocs.sistprodv1.services.exceptions.ObjectNotFountException;

@Service
public class SistemaProducaoService {

	@Autowired
	private SistemaProducaoRepository sistemaRepository; 
		
	@Autowired
	private UsuarioService usuarioService;
	
	
	
	public SistemaProducao buscar(Integer id){
		UserSS user = UserService.authenticated();
		if (user==null) {
			throw new AuthorizationException("Acesso negado: faça login!");
		}
		Optional<SistemaProducao> obj = sistemaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! ID: "+id+ " Nome: "+SistemaProducao.class.getName()));
	}
	
	/*public SistemaProducao buscar(Integer id){
		UserSS user = UserService.authenticated();
		if (user==null) {
			throw new AuthorizationException("Acesso negado: faça login!");
		}
		Usuario usuario = usuarioService.find(user.getId());
		SistemaProducao obj = sistemaRepository.findByUsuario(usuario);
		return obj;
	}*/
	
	public SistemaProducao insert(SistemaProducao obj) {
		obj.setId(null);
		obj.setData(new Date());
		obj = sistemaRepository.save(obj);	
		return obj;
	}
	
	public SistemaProducao update(SistemaProducao obj) {
		SistemaProducao newObj = buscar(obj.getId());
		atualizaDados(newObj, obj);
		return sistemaRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		buscar(id);
		try {
			sistemaRepository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Sistema, ele possui várias dependências");
		}
	}
	
	public List<SistemaProducao> buscarTodos(){
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado: faça login!");
		}
		return sistemaRepository.findAll();
	}
	
	public SistemaProducao fromDTO(SistemaProducaoDTO objDTO) {
		return new SistemaProducao(objDTO.getId(), objDTO.getNome(), objDTO.getData() , objDTO.getComprimento(), objDTO.getLargura(), objDTO.getUsuario());
	}
	
	
	public SistemaProducao fromDTO(SistemaNewDTO objDTO) {
		Usuario user = usuarioService.find(objDTO.getUsuarioId());
		SistemaProducao sistema = new SistemaProducao(objDTO.getId(), objDTO.getNome(), objDTO.getData(), objDTO.getComprimento(), objDTO.getLargura(), user);
		return sistema;
	}
		
	private void atualizaDados(SistemaProducao newObj, SistemaProducao obj) {
		newObj.setNome(obj.getNome());
		newObj.setComprimento(obj.getComprimento());
		newObj.setLargura(obj.getLargura());
	}
	
	/*Este findPage permite ver todos os sistemas
	public Page<SistemaProducao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		return sistemaRepository.findAll(pageRequest);		
	}*/
	
	/*Este findPage só mostra os sistemas do usuário específico*/
	public Page<SistemaProducao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado: faça login!");
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Usuario usuario = usuarioService.find(user.getId());
		return sistemaRepository.findByUsuario(usuario, pageRequest);
	}
	
	
}
