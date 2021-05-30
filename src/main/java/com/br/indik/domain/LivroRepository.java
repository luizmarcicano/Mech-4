package com.br.indik.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long>{

	List<Livro> findByTitulo(String titulo);

}