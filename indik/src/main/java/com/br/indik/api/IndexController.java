package com.br.indik.api;

import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	@RequestMapping("/")
	public String index(){
		return "cadastro";
	}
	
	@RequestMapping(value = "/cadastrarUsuario", method =RequestMethod.GET)
	public String cadastro(){
		return "cadastro";
	}
	
	@RequestMapping(value = "/cadastrarUsuario", method =RequestMethod.POST)
	public String formulario(){
		return "redirect:/";
	}
	//@RequestParam("id")Long id,@RequestParam("nomeCompleto")String nomeCompleto,@RequestParam("cidade")String cidade, @RequestParam("estado")String estado, @RequestParam("dataNascimento")Date dataNascimento, @RequestParam("username")String username, @RequestParam("senha")String senha
}