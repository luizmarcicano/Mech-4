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


import com.br.indik.domain.Livro;
import com.br.indik.domain.LivroService;
import com.br.indik.domain.dto.LivroDTO;


@RestController
@RequestMapping("/api/v1/livros")
public class LivroController {

	@Autowired
	private LivroService service;

	@GetMapping()
	public ResponseEntity getLivro() {
		return ResponseEntity.ok(service.getLivros());
	}

	@GetMapping("/{id}")
	public ResponseEntity getLivroById(@PathVariable("id") Long id) {
		LivroDTO livroDTO = service.getLivrosById(id);

		return ResponseEntity.ok(livroDTO);
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity getLivroByTitulo(@PathVariable("titulo") String titulo) {
		List<LivroDTO> livros = service.getLivrosByTitulo(titulo);

		return livros.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(livros);
	}

	@PostMapping
	public ResponseEntity postLivro(@RequestBody Livro livro) {
		LivroDTO livroDTO = service.insert(livro);

		URI location = getUri(livroDTO.getId());
		return ResponseEntity.created(location).build();
	}
	
	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

	@PutMapping("/{id}")
	public ResponseEntity putLivro(@PathVariable("id") Long id, @RequestBody Livro livro) {

		livro.setId(id);

		LivroDTO livroDTO = service.update(livro, id);

		return livroDTO != null ? ResponseEntity.ok(livroDTO) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		service.delete(id);

		return ResponseEntity.ok().build();
	}

}
