package br.com.mjv.noticias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
	public ModelAndView home(@PageableDefault(size = 2) Pageable pageable) {
		
		Page<Noticia> noticias = noticiaService.listar(pageable);
//		System.out.println("total paginas >>>>>> " + noticias.getTotalPages());
//		System.out.println("total elementos >>>> " + noticias.getTotalElements());
//		System.out.println("pagina atual >>>>>>> " + noticias.getNumber());
		
		ModelAndView mv = new ModelAndView("noticia");
		mv.addObject("noticias", noticias);
		
		return mv;
	}
	
}
