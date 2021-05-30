package com.br.indik.domain.dto;

import java.util.Date;

import javax.persistence.Column;

import org.modelmapper.ModelMapper;

import com.br.indik.domain.Usuario;

import lombok.Data;

@Data
public class UsuarioDTO {

	private Long id;
	private String nomeCompleto;
	private String cidade;
	private String estado;
	private String username;
	private String senha;
	private String dataNascimento;

	public static UsuarioDTO create(Usuario usuario) {
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(usuario, UsuarioDTO.class);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
