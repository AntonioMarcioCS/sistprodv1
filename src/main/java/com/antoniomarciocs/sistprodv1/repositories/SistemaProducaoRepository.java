package com.antoniomarciocs.sistprodv1.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;
import com.antoniomarciocs.sistprodv1.domain.Usuario;

@Repository
public interface SistemaProducaoRepository extends JpaRepository<SistemaProducao, Integer>  {
	@Transactional(readOnly=true)
	Page<SistemaProducao> findByUsuario(Usuario usuario, Pageable pageRequest);
	
	//SistemaProducao findByUsuario(Usuario usuario);
}
