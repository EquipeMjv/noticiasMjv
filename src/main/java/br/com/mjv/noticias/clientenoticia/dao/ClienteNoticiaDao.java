package br.com.mjv.noticias.clientenoticia.dao;

import java.util.List;

import br.com.mjv.noticias.cliente.model.ClienteNoticia;

public interface ClienteNoticiaDao {

	List<ClienteNoticia> buscarAnimesPorIdCliente(Long clienteId);
	
	void associarAnime(Long clienteId, Long noticiaId);
	
}
