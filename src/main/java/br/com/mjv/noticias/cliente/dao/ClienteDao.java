package br.com.mjv.noticias.cliente.dao;

import br.com.mjv.noticias.cliente.model.Cliente;

public interface ClienteDao {

	Cliente buscarClientePorUsuario(String usuario);
	
}
