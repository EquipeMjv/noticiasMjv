package br.com.mjv.noticias.clientenoticia.service;

import java.util.List;

import br.com.mjv.noticias.clientenoticia.model.ClienteNoticia;
import br.com.mjv.noticias.exception.NoticiaJaAssociadaException;

public interface ClienteNoticiaService {

	/**
	 * Retorna uma lista de {@link ClienteNoticia} com base no id do cliente informado.
	 * @param clienteId
	 * @return
	 */
	public List<ClienteNoticia> listarNoticiasPorIdCliente(Long clienteId);
	
	/**
	 * Funcionalidade para associar uma {@link ClienteNoticia} ao perfil do cliente com base 
	 * no id da noticia e o id do cliente informado.
	 * @param clienteId, noticiaId
	 * @return
	 * @throws NoticiaJaAssociadaException Exception disparada se a noticia informada já estiver cadastrada previamente no banco.
	 */
	public void associarNoticiaCliente(Long clienteId, Long noticiaId) throws NoticiaJaAssociadaException;

}
