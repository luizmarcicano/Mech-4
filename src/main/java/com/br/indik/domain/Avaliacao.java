package com.br.indik.domain;

import java.beans.ConstructorProperties;

public class Avaliacao {
	
	private Long id;
	private String texto;
	private int nota;
	private String titulo;
	private int ano;
	private String dono;
	private String pais;

	
	
	
	public Avaliacao() {
		super();
	}
	
	@ConstructorProperties({"id", "texto", "nota", "titulo", "ano", "dono", "pais"})
	public Avaliacao(Long id, String texto, int nota, String titulo, int ano, String dono, String pais) {
		this.id = id;
		this.texto = texto;
		this.nota = nota;
		this.titulo = titulo;
		this.ano = ano;
		this.dono = dono;
		this.pais = pais;
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
