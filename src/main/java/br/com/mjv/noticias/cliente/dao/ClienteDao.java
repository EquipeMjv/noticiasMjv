package br.com.mjv.noticias.cliente.dao;

import java.util.List;

import br.com.mjv.noticias.cliente.model.Cliente;
import br.com.mjv.noticias.cliente.model.ClienteNoticia;

public interface ClienteDao {

	Cliente buscarClientePorUsuario(String usuario);

	List<ClienteNoticia> buscarAnimesPorIdCliente(Long clienteId);
	
}
