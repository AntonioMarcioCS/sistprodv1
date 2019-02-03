package com.antoniomarciocs.sistprodv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antoniomarciocs.sistprodv1.domain.SistemaProducao;

@Repository
public interface SistemaProducaoRepository extends JpaRepository<SistemaProducao, Integer>  {

}
