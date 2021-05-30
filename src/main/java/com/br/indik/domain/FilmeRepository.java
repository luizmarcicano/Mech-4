package com.br.indik.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

	List<Filme> findByTitulo(String titulo);

}