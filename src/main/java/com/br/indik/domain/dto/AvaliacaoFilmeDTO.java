package com.br.indik.domain.dto;

import org.modelmapper.ModelMapper;

import com.br.indik.domain.Avaliacao;

import lombok.Data;

@Data
public class AvaliacaoFilmeDTO {
	
	private Long id;
	private String texto;
	private int nota;
	private String titulo;
	private int ano;
	private String dono;
	private String pais;
	
	public static AvaliacaoFilmeDTO create(Avaliacao avaliacao) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(avaliacao, AvaliacaoFilmeDTO.class);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
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

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
