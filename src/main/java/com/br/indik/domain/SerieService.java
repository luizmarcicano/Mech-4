package com.br.indik.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.br.indik.api.exception.ObjectNotFoundException;
import com.br.indik.domain.dto.SerieDTO;

import java.util.ArrayList;

@Service
public class SerieService{

	@Autowired
	SerieRepository rep;

	public List<SerieDTO> getSerie() {

		return rep.findAll().stream().map(SerieDTO::create).collect(Collectors.toList());

	}

	public SerieDTO getSeriesById(Long id) {
		return rep.findById(id).map(SerieDTO::create).orElseThrow(() -> new ObjectNotFoundException("Serie não encontrado."));
	}

	public List<SerieDTO> getSeriesByTitulo(String titulo) {
		return rep.findByTitulo(titulo).stream().map(SerieDTO::create).collect(Collectors.toList());
	}

	public Serie save(Serie serie) {
		return rep.save(serie);
	}

	public SerieDTO insert(Serie serie) {
		Assert.isNull(serie.getId(), "Não foi possível inserir o registro");

		return SerieDTO.create(rep.save(serie));
	}

	public SerieDTO update(Serie serie, Long id) {
		Assert.notNull(id, "Não foi possível atualizar o filme.");

		// Busca o usuário no banco de dados
		Optional<Serie> optional = rep.findById(id);
		if (optional.isPresent()) {
			Serie db = optional.get();

			// Copiar as propriedades do registro que vou alterar
			db.setTitulo(serie.getTitulo());
			db.setAno(serie.getAno());
			db.setDiretor(serie.getDiretor());
			db.setPais(serie.getPais());
			db.setElenco(serie.getElenco());
			db.setTemporadas(serie.getTemporadas());
			// Atualiza o Usuário
			rep.save(db);

			return SerieDTO.create(db);
		} else {
			return null;
		}

	}

	public void delete(Long id) {
		rep.deleteById(id);
	}
	
}
