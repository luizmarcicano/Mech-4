package com.br.indik;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.indik.domain.Usuario;
import com.br.indik.domain.UsuarioService;

@SpringBootTest
class IndikApplicationTests {

	@Autowired
	private UsuarioService service;
	
	@Test
	public void testeInsertUsuario() {
		
	}

}
