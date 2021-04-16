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

import com.br.indik.domain.Usuario;
import com.br.indik.domain.UsuarioService;
import com.br.indik.domain.dto.UsuarioDTO;

@RestController
@RequestMapping("/api")
public class UsuariosController {

	@Autowired
	private UsuarioService service;

	@GetMapping()
	public String getWelcome() {
		return "Hello World";
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity getUser() {
		return ResponseEntity.ok(service.getUsuarios());
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity getUserById(@PathVariable("id") Long id) {
		UsuarioDTO usuarioDTO = service.getUsuariosById(id);

		return ResponseEntity.ok(usuarioDTO);
	}

	@GetMapping("/usuarios/username/{username}")
	public ResponseEntity getUserByUsername(@PathVariable("username") String username) {
		List<UsuarioDTO> usuarios = service.getUsuariosByUsername(username);

		return usuarios.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(usuarios);
	}

	@PostMapping
	public ResponseEntity postUsuario(@RequestBody Usuario usuario) {

		UsuarioDTO usuarioDTO = service.insert(usuario);

		URI location = getUri(usuarioDTO.getId());
		return ResponseEntity.created(location).build();

	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity putUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {

		usuario.setId(id);

		UsuarioDTO userDTO = service.update(usuario, id);

		return userDTO != null ? ResponseEntity.ok(userDTO) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		service.delete(id);

		return ResponseEntity.ok().build();
	}

}
