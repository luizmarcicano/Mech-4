package com.br.indik.domain.dto;

import org.modelmapper.ModelMapper;

import com.br.indik.domain.Serie;

import lombok.Data;

@Data
public class SerieDTO {
	

	private Long id;
	private String titulo;
	private int ano;
	private String diretor;
	private String pais;
	private String elenco;
	private int temporadas;
	
	public static SerieDTO create(Serie serie) {
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(serie, SerieDTO.class);
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

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getElenco() {
		return elenco;
	}

	public void setElenco(String elenco) {
		this.elenco = elenco;
	}

	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}
	
	
	
}