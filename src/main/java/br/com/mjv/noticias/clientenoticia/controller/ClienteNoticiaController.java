package br.com.mjv.noticias.clientenoticia.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mjv.noticias.cliente.model.ClienteNoticia;
import br.com.mjv.noticias.clientenoticia.service.ClienteNoticiaService;

@Controller
@RequestMapping("/clientes")
public class ClienteNoticiaController {

	@Autowired
	private ClienteNoticiaService clienteNoticiaService;
	
	
	@GetMapping("/{clienteId}/animes")
	public ModelAndView listarAnimes(@PathVariable Long clienteId, HttpServletRequest request) {
		
		HttpSession sessao = request.getSession();
		Object usuarioLogado = sessao.getAttribute("usuarioLogado");
		
		if (usuarioLogado == null) {
			return new ModelAndView("redirect:/login");
		}
		
		List<ClienteNoticia> clienteNoticias = clienteNoticiaService.buscarAnimesPorIdCliente(clienteId);
		
		ModelAndView mv = new ModelAndView("/cliente/animes");
		mv.addObject("animes", clienteNoticias);
		
		return mv; 
	}
	
	@PostMapping("/{clienteId}/animes/{noticiaId}")
	public ModelAndView associarAnimeCliente(@PathVariable Long clienteId, @PathVariable Long noticiaId, HttpServletRequest request) {
		clienteNoticiaService.associarAnimeCliente(clienteId, noticiaId);
		
		return listarAnimes(clienteId, request);
	}
}
