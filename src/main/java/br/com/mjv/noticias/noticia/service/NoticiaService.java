package br.com.mjv.noticias.noticia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.mjv.noticias.noticia.dao.NoticiaDao;
import br.com.mjv.noticias.noticia.model.Noticia;

@Service
public class NoticiaService {

	@Autowired
	private NoticiaDao dao;
	
	public List<Noticia> listar() {
		return dao.listarTodos();
	}
	
	public Page<Noticia> listar(Pageable pageable) {
		return dao.listarTodos(pageable);
	}
	
}
