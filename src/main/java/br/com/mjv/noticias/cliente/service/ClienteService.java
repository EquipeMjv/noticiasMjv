package br.com.mjv.noticias.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.noticias.cliente.dao.ClienteDao;
import br.com.mjv.noticias.cliente.model.Cliente;
import br.com.mjv.noticias.exception.EntidadeNaoEncontradaException;

@Service
public class ClienteService {

	@Autowired
	private ClienteDao dao;
	
	public Cliente buscarClientePorUsuario(String usuario) throws EntidadeNaoEncontradaException {
		
		Cliente cliente = dao.buscarClientePorUsuario(usuario);
		
		if(cliente == null) {
			throw new EntidadeNaoEncontradaException("Não foi encontrado o cadastro do usuário " + usuario);
		}
		
		return cliente; 
	}

}
