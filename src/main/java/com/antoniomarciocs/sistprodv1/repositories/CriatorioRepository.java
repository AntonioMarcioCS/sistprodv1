package com.antoniomarciocs.sistprodv1.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.antoniomarciocs.sistprodv1.domain.Criatorio;
import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;

@Repository
public interface CriatorioRepository extends JpaRepository<Criatorio, Integer>  {
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Criatorio obj INNER JOIN obj.sistema sistema WHERE obj.nome LIKE %:nome% AND sistema IN :sistema")
	Page<Criatorio> findDistinctByNomeContainingAndSistemasIn(@Param("nome") String nome, @Param("sistema") List<SistemaProducao> sistemas, Pageable pageRequest);
	 
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Criatorio obj WHERE obj.sistema.id = :sistemaId ORDER BY obj.nome")
	public List<Criatorio> findCriatorios(@Param("sistemaId") Integer sistema_id);
}
