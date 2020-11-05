package br.com.mjv.noticias.noticia.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mjv.noticias.noticia.model.Noticia;
import br.com.mjv.noticias.noticia.service.NoticiaService;

@Controller
@RequestMapping("/noticias")
public class NoticiaController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NoticiaController.class);

	@Autowired
	private NoticiaService noticiaService;
		
	@GetMapping
	public ModelAndView home(HttpServletRequest request) {
		LOGGER.info("Inicio do método home()");
		
		HttpSession sessao = request.getSession();
		Object usuarioLogado = sessao.getAttribute("usuarioLogado");
		
		if (usuarioLogado == null) {
			return new ModelAndView("redirect:/login");
		}
		
		List<Noticia> noticias = noticiaService.listar();
		
		ModelAndView mv = new ModelAndView("/noticia/noticia");
		mv.addObject("pagina", noticias);

		LOGGER.info("Fim do método home()");
		return mv;
	}
	
	@GetMapping("/nova")
	public ModelAndView criarNoticia(HttpServletRequest request) {
		LOGGER.info("Inicio do método criarNoticia()");
		
		HttpSession sessao = request.getSession();
		Object usuarioLogado = sessao.getAttribute("usuarioLogado");
		
		if (usuarioLogado == null) {
			return new ModelAndView("redirect:/login");
		}
		
		LOGGER.info("Fim do método criarNoticia()");
		return new ModelAndView("noticia/noticiaForm");
	}
	
	@PostMapping("/nova")
	public String adicionarNoticia(Noticia noticia) {
		LOGGER.info("Inicio do método adicionarNoticia()");
		
		noticiaService.adicionar(noticia);
		
		LOGGER.info("Fim do método adicionarNoticia()");
		return "redirect:/noticias";
	}
			
}
