package br.com.mjv.noticias.cliente.dao;

import org.springframework.dao.EmptyResultDataAccessException;

import br.com.mjv.noticias.cliente.model.Cliente;

public interface ClienteDao {

	/**
	 * Retorna um {@link Cliente} com base no usuario informado.
	 * @param usuario
	 * @return
	 * @throws EmptyResultDataAccessException Exception disparada se o usuario informado não estiver cadastrado previamente no banco.
	 */
	Cliente buscarClientePorUsuario(String usuario) throws EmptyResultDataAccessException;
	
}
