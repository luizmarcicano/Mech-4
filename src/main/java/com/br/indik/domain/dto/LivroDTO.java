package com.br.indik.domain.dto;

import org.modelmapper.ModelMapper;

import com.br.indik.domain.Livro;

import lombok.Data;

@Data
public class LivroDTO {

	private Long id;
	private String titulo;
	private int ano;
	private String autor;
	private String pais;
	private String editora;
	
	public static LivroDTO create(Livro livro) {
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(livro, LivroDTO.class);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	
}