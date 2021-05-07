package com.br.indik.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String index(){
		return "index";
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	@RequestMapping(value="/cadastro", method= RequestMethod.GET)
	public String cadastro(){
		return "cadastro";
	}
	@RequestMapping(value="/cadastro", method= RequestMethod.POST)
	public String cadastrado(){
		return "redirect:cadastro";
	}
}