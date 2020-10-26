package br.com.mjv.noticias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.noticias.dao.ClienteDao;
import br.com.mjv.noticias.model.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteDao dao;
	
	public Cliente buscarClientePorUsuario(String usuario) {
		return dao.buscarClientePorUsuario(usuario);
	}

}
