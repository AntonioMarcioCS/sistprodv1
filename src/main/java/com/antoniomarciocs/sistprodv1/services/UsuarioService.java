package com.antoniomarciocs.sistprodv1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antoniomarciocs.sistprodv1.domain.Usuario;
import com.antoniomarciocs.sistprodv1.domain.enums.Perfil;
import com.antoniomarciocs.sistprodv1.domain.enums.TipoUsuario;
import com.antoniomarciocs.sistprodv1.dto.UsuarioDTO;
import com.antoniomarciocs.sistprodv1.repositories.UsuarioRepository;
import com.antoniomarciocs.sistprodv1.security.UserSS;
import com.antoniomarciocs.sistprodv1.services.exceptions.AuthorizationException;
import com.antoniomarciocs.sistprodv1.services.exceptions.DataIntegrityException;
import com.antoniomarciocs.sistprodv1.services.exceptions.ObjectNotFountException;

@Service
public class UsuarioService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UsuarioRepository repo; 
	
	public Usuario buscar(Integer id){
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException("Objeto não encontrado! ID:"+id+ " Nome:"
		+Usuario.class.getName()));
	}
	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Usuario update(Usuario obj) {
		Usuario newObj = buscar(obj.getId());
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
	
	public List<Usuario> buscarTodos(){
		return repo.findAll();
	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		return repo.findAll(pageRequest);	
	}
	
	public Usuario fromDTO(UsuarioDTO objDTO) {
		return new Usuario(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), objDTO.getCpf(),TipoUsuario.toEnum(objDTO.getTipo()), pe.encode(objDTO.getSenha()) );
	}
	
	private void atualizaDados(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
}
