package com.br.indik.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long>{

	List<Serie> findByTitulo(String titulo);

}
