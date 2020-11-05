package br.com.mjv.noticias.noticia.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.mjv.noticias.noticia.model.Noticia;

public interface NoticiaService {
	
	/**
	 * Retorna uma lista de {@link Noticia}.
	 * @param
	 * @return
	 */
	public List<Noticia> listar();
	
	/**
	 * Retorna uma página de {@link Noticia} tendo um {@link Pageable} como parâmetro e assim obtendo métodos
	 * para trabalhar com paginação. 
	 * @param pageable
	 * @return
	 */
	public Page<Noticia> listar(Pageable pageable);

	/**
	 * Funcionalidade para incluir no banco de dados uma nova {@link Noticia}. 
	 * @param noticia
	 * @return
	 */
	public Long adicionar(Noticia noticia);
	
	/**
	 * Retorna uma {@link Noticia} com base no id informado.
	 * @param noticiaId
	 * @return
	 */
	public Noticia buscarPorId(Long noticiaId);
	
}
