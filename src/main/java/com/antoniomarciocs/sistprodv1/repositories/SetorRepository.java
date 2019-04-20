package com.antoniomarciocs.sistprodv1.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.antoniomarciocs.sistprodv1.domain.Setor;
import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer>  {

	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Setor obj INNER JOIN obj.sistema sist WHERE obj.nome LIKE %:nome% AND sist IN :sistema")
	Page<Setor> findDistinctByNomeContainingAndSistemaProducaoIn(@Param("nome") String nome, @Param("sistema") Optional<SistemaProducao> sistema, Pageable pageRequest);
	
}
