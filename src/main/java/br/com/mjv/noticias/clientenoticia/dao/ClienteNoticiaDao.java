package br.com.mjv.noticias.clientenoticia.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import br.com.mjv.noticias.clientenoticia.model.ClienteNoticia;

public interface ClienteNoticiaDao {

	/**
	 * Retorna uma lista de {@link ClienteNoticia} com base no id do cliente informado.
	 * @param clienteId
	 * @return
	 * @throws EmptyResultDataAccessException Exception disparada se o cliente informado não tiver cadastro previamente no banco
	 */
	List<ClienteNoticia> listarNoticiasPorIdCliente(Long clienteId) throws EmptyResultDataAccessException;
	
	/**
	 * Retorna uma {@link ClienteNoticia} com base no id da noticia e o id do cliente informado.
	 * @param clienteId, noticiaId
	 * @return
	 * @throws EmptyResultDataAccessException Exception disparada se a noticia ou cliente informados não tiver cadastro previamente no banco
	 */
	ClienteNoticia buscarNoticiaPorIdCliente(Long clienteId, Long noticiaId) throws EmptyResultDataAccessException;
	
	/**
	 * Funcionalidade para associar uma {@link ClienteNoticia} ao perfil do cliente com base 
	 * no id da noticia e o id do cliente informado.
	 * @param clienteId, noticiaId
	 * @return
	 */
	void associarNoticia(Long clienteId, Long noticiaId);
	
}
