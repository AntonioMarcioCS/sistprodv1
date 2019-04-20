package com.antoniomarciocs.sistprodv1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antoniomarciocs.sistprodv1.domain.Cultura;
import com.antoniomarciocs.sistprodv1.dto.CulturaDTO;
import com.antoniomarciocs.sistprodv1.repositories.CulturaRepository;
import com.antoniomarciocs.sistprodv1.security.UserSS;
import com.antoniomarciocs.sistprodv1.services.exceptions.AuthorizationException;
import com.antoniomarciocs.sistprodv1.services.exceptions.DataIntegrityException;
import com.antoniomarciocs.sistprodv1.services.exceptions.ObjectNotFountException;

@Service
public class CulturaService {

	
	@Autowired
	private CulturaRepository repo; 
	
	
	public Cultura find(Integer id){
		UserSS user = UserService.authenticated();
		if (user==null || !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		Optional<Cultura> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException("Objeto não encontrado! ID:"+id+ " Nome:"
		+Cultura.class.getName()));
	}
	
	@Transactional
	public Cultura insert(Cultura obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Cultura update(Cultura obj) {
		Cultura newObj = find(obj.getId());
		atualizaDados(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um usuário com dependências");
		}
	}
	
	public List<Cultura> buscarTodos(){
		return repo.findAll();
	}
	
	public Page<Cultura> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		return repo.findAll(pageRequest);	
	}
	
	public Cultura fromDTO(CulturaDTO objDTO) {
		return new Cultura(objDTO.getId(), objDTO.getNome());
	}
	
	private void atualizaDados(Cultura newObj, Cultura obj) {
		newObj.setNome(obj.getNome());
	}
}
