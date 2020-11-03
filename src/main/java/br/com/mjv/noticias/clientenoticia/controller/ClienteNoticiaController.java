package br.com.mjv.noticias.clientenoticia.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mjv.noticias.clientenoticia.model.ClienteNoticia;
import br.com.mjv.noticias.clientenoticia.service.ClienteNoticiaService;
import br.com.mjv.noticias.exception.NoticiaJaAssociadaException;

@Controller
@RequestMapping("/clientes")
public class ClienteNoticiaController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteNoticiaController.class);

	@Autowired
	private ClienteNoticiaService clienteNoticiaService;
	
	
	@GetMapping("/{clienteId}/animes")
	public ModelAndView listarAnimes(@PathVariable Long clienteId, HttpServletRequest request) {
		LOGGER.info("Inicio do método listarAnimes");
				
		HttpSession sessao = request.getSession();
		Object usuarioLogado = sessao.getAttribute("usuarioLogado");
		
		if (usuarioLogado == null) {
			return new ModelAndView("redirect:/login");
		}
		
		List<ClienteNoticia> clienteNoticias = clienteNoticiaService.listarAnimesPorId(clienteId);
		
		ModelAndView mv = new ModelAndView("/cliente/anime");
		mv.addObject("animes", clienteNoticias);
		
		LOGGER.info("Fim do método listarAnimes");
		return mv; 
	}
	
	@PostMapping("/{clienteId}/animes/{noticiaId}")
	public ModelAndView associarAnimeCliente(@PathVariable Long clienteId, @PathVariable Long noticiaId, 
			RedirectAttributes atributos, HttpServletRequest request) {
		try {
			LOGGER.info("Inicio do método associarAnimeCliente");
			
			clienteNoticiaService.associarAnimeCliente(clienteId, noticiaId);
			
			LOGGER.info("Fim do método associarAnimeCliente");
			return listarAnimes(clienteId, request);
			
		} catch (NoticiaJaAssociadaException e) {
			atributos.addFlashAttribute("mensagem", e.getMessage());
			LOGGER.error(e.getMessage(), e);
			return new ModelAndView("redirect:/noticias");
		}
		
	}
}
