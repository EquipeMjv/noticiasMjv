package br.com.mjv.noticias.cliente.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.mjv.noticias.cliente.model.Cliente;
import br.com.mjv.noticias.cliente.model.ClienteRowMapper;

@Repository
public class ClienteDaoImpl implements ClienteDao {
	
	@Autowired
	private NamedParameterJdbcTemplate template;


	@Override
	public Cliente buscarClientePorUsuario(String usuario) {
		try {
			String sql = "SELECT id, nome, usuario, senha FROM TB_CLIENTE WHERE usuario = :usuario";
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("usuario", usuario);
			
			Cliente cliente = template.queryForObject(sql, params, new ClienteRowMapper());
			
			return cliente;
			
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
