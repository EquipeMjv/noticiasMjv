package br.com.mjv.noticias.cliente.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.noticias.cliente.dao.ClienteDao;
import br.com.mjv.noticias.cliente.model.Cliente;
import br.com.mjv.noticias.exception.EntidadeNaoEncontradaException;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private ClienteDao dao;
	
	@Override
	public Cliente buscarClientePorUsuario(String usuario) throws EntidadeNaoEncontradaException {
		
		Cliente cliente = dao.buscarClientePorUsuario(usuario);
		
		if(cliente == null) {
			LOGGER.error(String.format("Não foi encontrado o cadastro de cliente com o usuário %s ", usuario));
			throw new EntidadeNaoEncontradaException(String.format("Não foi encontrado o cadastro de cliente com o usuário %s ", usuario));
		}
		
		return cliente; 
	}

}
