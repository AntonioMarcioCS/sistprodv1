package com.antoniomarciocs.sistprodv1.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.antoniomarciocs.sistprodv1.domain.Animal;
import com.antoniomarciocs.sistprodv1.domain.Criatorio;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>  {
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Animal obj INNER JOIN obj.criatorio criatorio WHERE obj.nome LIKE %:nome% AND criatorio IN :criatorio")
	Page<Animal> findDistinctByNomeContainingAndCriatorioIn(@Param("nome") String nome, @Param("criatorio") List<Criatorio> criatorios, Pageable pageRequest);
}
