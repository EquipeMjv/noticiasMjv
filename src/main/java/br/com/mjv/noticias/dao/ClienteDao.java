package br.com.mjv.noticias.dao;

import br.com.mjv.noticias.model.Cliente;

public interface ClienteDao {

	Cliente buscarClientePorUsuario(String usuario);
	
}
