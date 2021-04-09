package com.br.indik.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="nome_completo")
	private String nomeCompleto;

	@Column
	private String cidade;

	@Column
	private String estado;

	@Column
	private String username;

	@Column
	private String senha;

	@Column(name = "dt_nascimento")
	private Date dataNascimento;


}
