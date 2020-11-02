package br.com.mjv.noticias.noticia.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.mjv.noticias.noticia.model.Noticia;

public interface NoticiaDao  {

	List<Noticia> listarTodos();
	
	Page<Noticia> listarTodos(Pageable pageable);
	
	Long adicionar(Noticia noticia);
	
}
