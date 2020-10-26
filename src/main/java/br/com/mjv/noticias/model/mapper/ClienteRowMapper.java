package br.com.mjv.noticias.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.mjv.noticias.model.Cliente;

/**
 * classe RowMapper da classe de modelo {@link Cliente} da tabela TB_CLIENTE
 * @author thiago
 *
 */

public class ClienteRowMapper implements RowMapper<Cliente> {

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Cliente usuario = new Cliente();
		usuario.setId(rs.getLong("id"));
		usuario.setNome(rs.getString("nome"));
		usuario.setUsuario(rs.getString("usuario"));
		usuario.setSenha(rs.getString("senha"));
		
		return usuario;
	}

}
