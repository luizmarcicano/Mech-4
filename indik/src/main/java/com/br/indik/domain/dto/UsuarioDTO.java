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
	private Date dataNascimento;

	public static UsuarioDTO create(Usuario usuario) {
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(usuario, UsuarioDTO.class);
	}
}
