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
import com.antoniomarciocs.sistprodv1.domain.Setor;

@Repository
public interface CanteiroRepository extends JpaRepository<Canteiro, Integer>  {
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Canteiro obj INNER JOIN obj.setor setor WHERE obj.nome LIKE %:nome% AND setor IN :setor")
	Page<Canteiro> findDistinctByNomeContainingAndSestoresIn(@Param("nome") String nome, @Param("setor") List<Setor> setores, Pageable pageRequest);

}
