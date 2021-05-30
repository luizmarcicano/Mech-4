package com.br.indik.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.br.indik.api.exception.ObjectNotFoundException;
import com.br.indik.domain.dto.FilmeDTO;

import java.util.ArrayList;

@Service
public class FilmeService {

	@Autowired
	FilmeRepository rep;

	public List<FilmeDTO> getFilmes() {

		return rep.findAll().stream().map(FilmeDTO::create).collect(Collectors.toList());

	}

	public FilmeDTO getFilmesById(Long id) {
		return rep.findById(id).map(FilmeDTO::create).orElseThrow(() -> new ObjectNotFoundException("Filme não encontrado."));
	}

	public List<FilmeDTO> getFilmesByTitulo(String titulo) {
		return rep.findByTitulo(titulo).stream().map(FilmeDTO::create).collect(Collectors.toList());
	}

	public Filme save(Filme filme) {
		return rep.save(filme);
	}

	public FilmeDTO insert(Filme filme) {
		Assert.isNull(filme.getId(), "Não foi possível inserir o registro");

		return FilmeDTO.create(rep.save(filme));
	}

	public FilmeDTO update(Filme filme, Long id) {
		Assert.notNull(id, "Não foi possível atualizar o filme.");

		// Busca o usuário no banco de dados
		Optional<Filme> optional = rep.findById(id);
		if (optional.isPresent()) {
			Filme db = optional.get();

			// Copiar as propriedades do registro que vou alterar
			db.setTitulo(filme.getTitulo());
			db.setAno(filme.getAno());
			db.setDiretor(filme.getDiretor());
			db.setPais(filme.getPais());
			db.setElenco(filme.getElenco());

			// Atualiza o Usuário
			rep.save(db);

			return FilmeDTO.create(db);
		} else {
			return null;
		}

	}

	public void delete(Long id) {
		rep.deleteById(id);
	}
}
