package com.antoniomarciocs.sistprodv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antoniomarciocs.sistprodv1.domain.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer>  {

}
