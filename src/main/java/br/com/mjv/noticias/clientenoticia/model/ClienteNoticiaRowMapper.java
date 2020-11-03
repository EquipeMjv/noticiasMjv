package br.com.mjv.noticias.clientenoticia.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ClienteNoticiaRowMapper implements RowMapper<ClienteNoticia> {

	@Override
	public ClienteNoticia mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ClienteNoticia clienteNoticia = new ClienteNoticia();
		clienteNoticia.setClienteId(rs.getLong("cliente_id"));
		clienteNoticia.setNoticiaId(rs.getLong("noticia_id"));
		clienteNoticia.setTitulo(rs.getString("titulo"));
		
		return clienteNoticia;
	}
	

}
