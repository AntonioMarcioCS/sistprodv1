package com.antoniomarciocs.sistprodv1.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.antoniomarciocs.sistprodv1.domain.Irrigacao;
import com.antoniomarciocs.sistprodv1.domain.Plantio;

@Repository
public interface IrrigacaoRepository extends JpaRepository<Irrigacao, Integer>  {
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Irrigacao obj INNER JOIN obj.plantio plantio WHERE plantio IN :plantio")
	Page<Irrigacao> findDistinctByIdContainingAndPlantioIn(@Param("plantio") List<Plantio> plantio, Pageable pageRequest);
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Irrigacao obj WHERE obj.plantio.id = :plantioId ORDER BY obj.data")
	public List<Irrigacao> findIrrigacoes(@Param("plantioId") Integer plantio_id);
}
