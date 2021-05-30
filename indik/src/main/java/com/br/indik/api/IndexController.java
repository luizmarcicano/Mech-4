package com.br.indik.api;

import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
	
	@GetMapping("/user/{id}")
	public String getUsuariosById(@PathVariable("id")Long id) {
		return "Usuário" + id;
	}
	
	@PostMapping("/cadastro")
	public String postCadastro(@RequestParam("id") Long id, @RequestParam("nome") String nome) {
		return "Usuário " + id;
	}

	
	//@RequestParam("id")Long id,@RequestParam("nomeCompleto")String nomeCompleto,@RequestParam("cidade")String cidade, @RequestParam("estado")String estado, @RequestParam("dataNascimento")Date dataNascimento, @RequestParam("username")String username, @RequestParam("senha")String senha
}
