package com.br.indik.api;

import java.net.URI;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.indik.domain.Serie;
import com.br.indik.domain.SerieService;
import com.br.indik.domain.dto.SerieDTO;

@RestController
@RequestMapping("/api/v1/series")
public class SerieController{

	@Autowired
	private SerieService service;

	@GetMapping()
	public ResponseEntity getSerie() {
		return ResponseEntity.ok(service.getSerie());
	}

	@GetMapping("/{id}")
	public ResponseEntity getSerieById(@PathVariable("id") Long id) {
		SerieDTO serieDTO = service.getSeriesById(id);

		return ResponseEntity.ok(serieDTO);
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity getSerieByTitulo(@PathVariable("titulo") String titulo) {
		List<SerieDTO> series = service.getSeriesByTitulo(titulo);

		return series.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(series);
	}

	@PostMapping
	public ResponseEntity postSerie(@RequestBody Serie serie) {
		SerieDTO serieDTO = service.insert(serie);

		URI location = getUri(serieDTO.getId());
		return ResponseEntity.created(location).build();
	}
	

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

	@PutMapping("/{id}")
	public ResponseEntity putSerie(@PathVariable("id") Long id, @RequestBody Serie serie) {

		serie.setId(id);

		SerieDTO serieDTO = service.update(serie, id);

		return serieDTO != null ? ResponseEntity.ok(serieDTO) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		service.delete(id);

		return ResponseEntity.ok().build();
	}

}
