package br.com.mjv.noticias.clientenoticia.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.noticias.clientenoticia.dao.ClienteNoticiaDao;
import br.com.mjv.noticias.clientenoticia.model.ClienteNoticia;
import br.com.mjv.noticias.exception.NoticiaJaAssociadaException;

@Service
public class ClienteNoticiaServiceImpl implements ClienteNoticiaService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteNoticiaServiceImpl.class);

	@Autowired
	private ClienteNoticiaDao dao;
	
	@Override
	public List<ClienteNoticia> listarNoticiasPorIdCliente(Long clienteId) {
		List<ClienteNoticia> clienteNoticias = dao.listarNoticiasPorIdCliente(clienteId);
		return clienteNoticias;
	}
	
	@Override
	public void associarNoticiaCliente(Long clienteId, Long noticiaId) throws NoticiaJaAssociadaException {
		
		ClienteNoticia clienteNoticia = dao.buscarNoticiaPorIdCliente(clienteId, noticiaId);
		
		if (clienteNoticia != null) {
			LOGGER.error(String.format(String.format("Noticia %s já cadastrada no seu perfil", clienteNoticia.getTitulo())));
			throw new NoticiaJaAssociadaException(String.format("Noticia %s já cadastrada no seu perfil", clienteNoticia.getTitulo()));
		}
		
		dao.associarNoticia(clienteId, noticiaId);
	}

}
