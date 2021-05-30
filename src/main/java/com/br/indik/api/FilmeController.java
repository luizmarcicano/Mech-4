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

import com.br.indik.domain.Filme;
import com.br.indik.domain.FilmeService;
import com.br.indik.domain.dto.FilmeDTO;

@RestController
@RequestMapping("/api/v1/filmes")
public class FilmeController{

	@Autowired
	private FilmeService service;

	@GetMapping()
	public ResponseEntity getFilme() {
		return ResponseEntity.ok(service.getFilmes());
	}

	@GetMapping("/{id}")
	public ResponseEntity getFilmeById(@PathVariable("id") Long id) {
		FilmeDTO filmeDTO = service.getFilmesById(id);

		return ResponseEntity.ok(filmeDTO);
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity getFilmeByTitulo(@PathVariable("titulo") String titulo) {
		List<FilmeDTO> filmes = service.getFilmesByTitulo(titulo);

		return filmes.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(filmes);
	}

	@PostMapping
	public ResponseEntity postFilme(@RequestBody Filme filme) {
		FilmeDTO filmeDTO = service.insert(filme);

		URI location = getUri(filmeDTO.getId());
		return ResponseEntity.created(location).build();

	}
	

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

	@PutMapping("/{id}")
	public ResponseEntity putFilme(@PathVariable("id") Long id, @RequestBody Filme filme) {

		filme.setId(id);

		FilmeDTO filmeDTO = service.update(filme, id);

		return filmeDTO != null ? ResponseEntity.ok(filmeDTO) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		service.delete(id);

		return ResponseEntity.ok().build();
	}

}
