package br.com.mjv.noticias.clientenoticia.dao;

import java.util.List;

import br.com.mjv.noticias.clientenoticia.model.ClienteNoticia;

public interface ClienteNoticiaDao {

	List<ClienteNoticia> listarAnimesPorId(Long clienteId);
	
	ClienteNoticia buscarAnimePorId(Long clienteId, Long noticiaId);
	
	void associarAnime(Long clienteId, Long noticiaId);
	
}
