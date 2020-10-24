package br.com.mjv.noticias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mjv.noticias.model.Noticia;
import br.com.mjv.noticias.service.NoticiaService;

@Controller
@RequestMapping("/noticias")
public class NoticiaController {

	@Autowired
	private NoticiaService noticiaService;
		
	@GetMapping
	public ModelAndView home() {
		
		List<Noticia> noticias = noticiaService.listaNoticia();
		
		ModelAndView mv = new ModelAndView("noticia");
		mv.addObject("noticias", noticias);
		
		return mv;
	}
	
}
