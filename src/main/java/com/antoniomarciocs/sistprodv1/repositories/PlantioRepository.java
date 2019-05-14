package com.antoniomarciocs.sistprodv1.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.antoniomarciocs.sistprodv1.domain.Plantio;
import com.antoniomarciocs.sistprodv1.domain.Canteiro;

@Repository
public interface PlantioRepository extends JpaRepository<Plantio, Integer>  {
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Plantio obj INNER JOIN obj.canteiro canteiro WHERE obj.nome LIKE %:nome% AND canteiro IN :canteiro")
	Page<Plantio> findDistinctByNomeContainingAndCanteirosIn(@Param("nome") String nome, @Param("canteiro") List<Canteiro> canteiros, Pageable pageRequest);
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Plantio obj WHERE obj.canteiro.id = :canteiroId ORDER BY obj.nome")
	public List<Plantio> findPlantios(@Param("canteiroId") Integer canteiro_id);
}
