package br.com.mjv.noticias.login.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mjv.noticias.cliente.model.Cliente;
import br.com.mjv.noticias.cliente.service.ClienteService;
import br.com.mjv.noticias.exception.EntidadeNaoEncontradaException;
import br.com.mjv.noticias.login.model.Login;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public String login() {
		return "login";
	}
		
	@PostMapping
	public String autenticar(Login login, RedirectAttributes atributos, HttpServletRequest request) {
		try {
			Optional<Cliente> cliente = Optional.of(clienteService.buscarClientePorUsuario(login.getUsuario()));
			String senha = cliente.get().getSenha();
			
			HttpSession sessao = request.getSession();
			
								
			if (cliente.isPresent() && senha.equals(login.getSenha())) {
				sessao.setAttribute("usuarioLogado", cliente);
				return "redirect:noticias";
			}
			atributos.addFlashAttribute("mensagem", "Usuário e/ ou senha inválida.");
			return "redirect:/login";
			
		} catch (EntidadeNaoEncontradaException e) {
			atributos.addFlashAttribute("mensagem", "Usuário e/ ou senha inválida.");
			LOGGER.error(e.getMessage(), e);
			return "redirect:/login";
		}
	}
}
