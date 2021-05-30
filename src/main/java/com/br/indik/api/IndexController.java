package com.br.indik.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.indik.domain.Usuario;
import com.br.indik.domain.UsuarioService;
import com.br.indik.domain.dto.UsuarioDTO;
import com.br.indik.domain.Avaliacao;
import com.br.indik.domain.AvaliacaoFilmeDao;
import com.br.indik.domain.Filme;
import com.br.indik.domain.FilmeService;
import com.br.indik.domain.dto.FilmeDTO;

@Controller
public class IndexController {
	
	private AvaliacaoFilmeDao dao;
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private FilmeService serviceFilme;
	

	@RequestMapping(value="/", method= RequestMethod.GET)
	public String index(){
		return "index";
	}
	

	// LOGIN
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String logar(){
		return "homepage";
	}
	
	
	
	
	// HOME
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView homepage(){
		ModelAndView mv = new ModelAndView("homepage");
		List<UsuarioDTO> usu = service.getUsuarios();
		mv.addObject("homepage", usu);
		return mv;
	}
	
	
	// CADASTRO
	@RequestMapping(value="/cadastro", method= RequestMethod.GET)
	public String cadastro(){
		return "cadastro";
	}


	@RequestMapping(value="/cadastro", method=RequestMethod.POST)
    public String form(@RequestBody Usuario usuario, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastro";
        }

        UsuarioDTO usuarioDTO = service.insert(usuario);
        attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso!");
        return "redirect:/login";
    }
	
	
	
	//FORMULARIO 
	@RequestMapping(value="/form", method= RequestMethod.GET)
	public String avaliar(){
		return "formReview";
	}

	
	
	
	//MIDIAS
	@RequestMapping(value="/midias", method= RequestMethod.GET)
	public String midias(){
		return "midias";
	}
	
	
	//PERFIL
	@RequestMapping(value="/perfil", method= RequestMethod.GET)
	public String exibePerfil(){
		return "perfil";
	}
	//ALTERAPERFIL
	@RequestMapping(value="/alterarperfil", method= RequestMethod.GET)
	public String editorPerfil(){
		return "alterarperfil";
	}
	@RequestMapping(value="/alterarperfil", method= RequestMethod.POST)
	public String editarPerfil(){
		return "perfil";
	}
	
	
}