package br.com.mjv.noticias.cliente.service;

import br.com.mjv.noticias.cliente.model.Cliente;
import br.com.mjv.noticias.exception.EntidadeNaoEncontradaException;

public interface ClienteService {
	
	/**
	 * Retorna um {@link Cliente} com base no usuario informado.
	 * @param usuario
	 * @return
	 * @throws EntidadeNaoEncontradaException Exception disparada se o cliente informado não estiver cadastrada previamente no banco.
	 */
	public Cliente buscarClientePorUsuario(String usuario) throws EntidadeNaoEncontradaException;

}
