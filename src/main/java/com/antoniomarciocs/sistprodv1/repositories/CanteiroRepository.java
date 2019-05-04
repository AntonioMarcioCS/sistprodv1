package com.antoniomarciocs.sistprodv1.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.antoniomarciocs.sistprodv1.domain.Canteiro;
import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;

@Repository
public interface CanteiroRepository extends JpaRepository<Canteiro, Integer>  {
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Canteiro obj INNER JOIN obj.sistema sistema WHERE obj.nome LIKE %:nome% AND sistema IN :sistema")
	Page<Canteiro> findDistinctByNomeContainingAndSistemasIn(@Param("nome") String nome, @Param("sistema") List<SistemaProducao> sistemas, Pageable pageRequest);
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Canteiro obj WHERE obj.sistema.id = :sistemaId ORDER BY obj.nome")
	public List<Canteiro> findCanteiros(@Param("sistemaId") Integer sistema_id);
}
