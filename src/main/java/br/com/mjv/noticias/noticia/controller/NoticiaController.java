package br.com.mjv.noticias.noticia.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	@Autowired
	private NoticiaService noticiaService;
	
//	@GetMapping
//	public ModelAndView home(@PageableDefault(size = 2) Pageable pageable, HttpServletRequest request) {
//		
//		HttpSession sessao = request.getSession();
//		Object usuarioLogado = sessao.getAttribute("usuarioLogado");
//		
//		if (usuarioLogado == null) {
//			return new ModelAndView("redirect:/login");
//		}
//		
//		Page<Noticia> paginaNoticias = noticiaService.listar(pageable);
//						
//		ModelAndView mv = new ModelAndView("/noticia/noticia");
//		mv.addObject("pagina", paginaNoticias);
//				
//		return mv;
//	}
	
	@GetMapping
	public ModelAndView home(HttpServletRequest request) {
		
		HttpSession sessao = request.getSession();
		Object usuarioLogado = sessao.getAttribute("usuarioLogado");
		
		if (usuarioLogado == null) {
			return new ModelAndView("redirect:/login");
		}
		
		List<Noticia> noticias = noticiaService.listar();
		
		ModelAndView mv = new ModelAndView("/noticia/noticia");
		mv.addObject("pagina", noticias);
				
		return mv;
	}
	
	
	@GetMapping("/nova")
	public ModelAndView criarNoticia(HttpServletRequest request) {
		
		HttpSession sessao = request.getSession();
		Object usuarioLogado = sessao.getAttribute("usuarioLogado");
		
		if (usuarioLogado == null) {
			return new ModelAndView("redirect:/login");
		}
		
		return new ModelAndView("noticia/noticiaForm");
	}
	
	@PostMapping("/nova")
	public String adicionarNoticia(Noticia noticia) {
				
		noticiaService.adicionar(noticia);
		
		return "redirect:/noticias";
	}
			
}
