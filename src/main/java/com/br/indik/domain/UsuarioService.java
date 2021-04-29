package com.br.indik.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.br.indik.api.exception.ObjectNotFoundException;
import com.br.indik.domain.dto.UsuarioDTO;

import java.util.ArrayList;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository rep;

	public List<UsuarioDTO> getUsuarios() {

		return rep.findAll().stream().map(UsuarioDTO::create).collect(Collectors.toList());

	}

	public UsuarioDTO getUsuariosById(Long id) {
		return rep.findById(id).map(UsuarioDTO::create).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado."));
	}

	public List<UsuarioDTO> getUsuariosByUsername(String username) {
		return rep.findByUsername(username).stream().map(UsuarioDTO::create).collect(Collectors.toList());
	}

	public Usuario save(Usuario usuario) {
		return rep.save(usuario);
	}

	public UsuarioDTO insert(Usuario usuario) {
		Assert.isNull(usuario.getId(), "Não foi possível inserir o registro");

		return UsuarioDTO.create(rep.save(usuario));
	}

	public UsuarioDTO update(Usuario usuario, Long id) {
		Assert.notNull(id, "Não foi possível atualizar o usuário.");

		// Busca o usuário no banco de dados
		Optional<Usuario> optional = rep.findById(id);
		if (optional.isPresent()) {
			Usuario db = optional.get();

			// Copiar as propriedades do registro que vou alterar
			db.setNomeCompleto(usuario.getNomeCompleto());
			db.setCidade(usuario.getCidade());
			db.setEstado(usuario.getEstado());
			db.setUsername(usuario.getUsername());
			db.setSenha(usuario.getSenha());
			db.setDataNascimento(usuario.getDataNascimento());

			// Atualiza o Usuário
			rep.save(db);

			return UsuarioDTO.create(db);
		} else {
			return null;
		}

	}

	public void delete(Long id) {
		rep.deleteById(id);
	}
}
