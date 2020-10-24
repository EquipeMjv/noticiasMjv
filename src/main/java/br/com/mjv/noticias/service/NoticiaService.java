package br.com.mjv.noticias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.noticias.dao.NoticiaDao;
import br.com.mjv.noticias.model.Noticia;

@Service
public class NoticiaService {

	@Autowired
	private NoticiaDao dao;
	
	public List<Noticia> listaNoticia() {
		return dao.lista();
	}
	
}
