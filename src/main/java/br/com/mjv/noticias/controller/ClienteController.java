package br.com.mjv.noticias.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mjv.noticias.model.Cliente;
import br.com.mjv.noticias.model.dto.Login;
import br.com.mjv.noticias.service.ClienteService;

@Controller
@RequestMapping("/login")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public String login() {
		return "login";
	}
		
	@PostMapping
	public String autenticar(Login login, RedirectAttributes atributos) {
		Optional<Cliente> cliente = Optional.of(clienteService.buscarClientePorUsuario(login.getUsuario()));
		String senha = cliente.get().getSenha();
		
		if (cliente.isPresent() && senha.equals(login.getSenha())) {	
			return "redirect:noticias";
		}
		
		atributos.addFlashAttribute("mensagem", "Usuário e/ ou senha inválida.");
		
		return "redirect:/login";
	}
	
}
