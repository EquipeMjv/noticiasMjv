package br.com.mjv.noticias.clientenoticia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.noticias.cliente.model.ClienteNoticia;
import br.com.mjv.noticias.clientenoticia.dao.ClienteNoticiaDao;

@Service
public class ClienteNoticiaService {

	@Autowired
	private ClienteNoticiaDao dao;
	
	public List<ClienteNoticia> buscarAnimesPorIdCliente(Long clienteId) {
		List<ClienteNoticia> clienteNoticias = dao.buscarAnimesPorIdCliente(clienteId);
		return clienteNoticias;
	}
	
	public void associarAnimeCliente(Long clienteId, Long noticiaId) {
		dao.associarAnime(clienteId, noticiaId);
	}

}
