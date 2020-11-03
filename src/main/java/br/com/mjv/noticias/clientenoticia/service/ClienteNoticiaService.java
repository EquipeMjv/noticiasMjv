package br.com.mjv.noticias.clientenoticia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.noticias.clientenoticia.dao.ClienteNoticiaDao;
import br.com.mjv.noticias.clientenoticia.model.ClienteNoticia;
import br.com.mjv.noticias.exception.NoticiaJaAssociadaException;

@Service
public class ClienteNoticiaService {

	@Autowired
	private ClienteNoticiaDao dao;
	
	public List<ClienteNoticia> listarAnimesPorId(Long clienteId) {
		List<ClienteNoticia> clienteNoticias = dao.listarAnimesPorId(clienteId);
		return clienteNoticias;
	}
	
	public void associarAnimeCliente(Long clienteId, Long noticiaId) throws NoticiaJaAssociadaException {
		
		ClienteNoticia clienteNoticia = dao.buscarAnimePorId(clienteId, noticiaId);
		
		if (clienteNoticia != null) {
			throw new NoticiaJaAssociadaException(String.format("Anime %s já cadastrado no meu perfil", clienteNoticia.getTitulo()));
		}
		
		dao.associarAnime(clienteId, noticiaId);
	}

}
