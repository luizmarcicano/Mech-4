package com.br.indik.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.br.indik.api.exception.ObjectNotFoundException;
import com.br.indik.domain.dto.LivroDTO;

import java.util.ArrayList;

@Service
public class LivroService {

	@Autowired
	LivroRepository rep;

	public List<LivroDTO> getLivros() {

		return rep.findAll().stream().map(LivroDTO::create).collect(Collectors.toList());

	}

	public LivroDTO getLivrosById(Long id) {
		return rep.findById(id).map(LivroDTO::create).orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado."));
	}

	public List<LivroDTO> getLivrosByTitulo(String titulo) {
		return rep.findByTitulo(titulo).stream().map(LivroDTO::create).collect(Collectors.toList());
	}

	public Livro save(Livro livro) {
		return rep.save(livro);
	}

	public LivroDTO insert(Livro livro) {
		Assert.isNull(livro.getId(), "Não foi possível inserir o registro");

		return LivroDTO.create(rep.save(livro));
	}

	public LivroDTO update(Livro livro, Long id) {
		Assert.notNull(id, "Não foi possível atualizar o Livro.");

		// Busca o usuário no banco de dados
		Optional<Livro> optional = rep.findById(id);
		if (optional.isPresent()) {
			Livro db = optional.get();

			// Copiar as propriedades do registro que vou alterar
			db.setTitulo(livro.getTitulo());
			db.setAno(livro.getAno());
			db.setAutor(livro.getAutor());
			db.setPais(livro.getPais());
			db.setEditora(livro.getEditora());

			// Atualiza o Usuário
			rep.save(db);

			return LivroDTO.create(db);
		} else {
			return null;
		}

	}

	public void delete(Long id) {
		rep.deleteById(id);
	}
}
