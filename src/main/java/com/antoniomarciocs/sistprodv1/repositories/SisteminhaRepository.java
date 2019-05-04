package com.antoniomarciocs.sistprodv1.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;
import com.antoniomarciocs.sistprodv1.domain.Usuario;
import com.antoniomarciocs.sistprodv1.dto.SisteminhaDTO;

@Repository
public interface SisteminhaRepository extends JpaRepository<SistemaProducao, Integer>  {
	@Transactional(readOnly=true)
	Page<SisteminhaDTO> findByUsuario(Usuario usuario, Pageable pageRequest);
	
}
