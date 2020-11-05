package br.com.mjv.noticias.noticia.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.mjv.noticias.noticia.model.Noticia;

public interface NoticiaDao  {

	/**
	 * Retorna uma lista de {@link Noticia}.
	 * @param
	 * @return
	 */
	List<Noticia> listarTodos();
	
	/**
	 * Retorna uma página de {@link Noticia} tendo um {@link Pageable} como parâmetro e assim obtendo métodos
	 * para trabalhar com paginação. 
	 * @param pageable
	 * @return
	 */
	Page<Noticia> listarTodos(Pageable pageable);
	
	/**
	 * Funcionalidade para incluir no banco de dados uma nova {@link Noticia}. 
	 * @param noticia
	 * @return
	 */
	Long adicionar(Noticia noticia);
	
	/**
	 * Retorna uma {@link Noticia} com base no id informado.
	 * @param noticiaId
	 * @return
	 * @throws EmptyResultDataAccessException Exception disparada quando o id informado não tiver cadastrado previamente no banco.
	 */
	Noticia buscarPorId(Long noticiaId) throws EmptyResultDataAccessException;
	
}
