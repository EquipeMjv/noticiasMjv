package br.com.mjv.noticias.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mjv.noticias.cliente.model.ClienteNoticia;
import br.com.mjv.noticias.cliente.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping("/animes/{clienteId}")
	public ModelAndView listarAnimes(@PathVariable Long clienteId) {
		
		List<ClienteNoticia> clienteNoticias = clienteService.buscarAnimesPorIdCliente(clienteId);
		
		ModelAndView mv = new ModelAndView("/cliente/animes");
		mv.addObject("animes", clienteNoticias);
		
		return mv; 
	}
}
