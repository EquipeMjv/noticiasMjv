package br.com.mjv.noticias.cliente.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.mjv.noticias.cliente.model.Cliente;
import br.com.mjv.noticias.cliente.model.ClienteNoticia;
import br.com.mjv.noticias.cliente.model.ClienteNoticiaRowMapper;
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

	@Override
	public List<ClienteNoticia> buscarAnimesPorIdCliente(Long clienteId) {
		try {
			String sql = "SELECT cliente_id, noticia_id, titulo FROM TB_CLIENTE_NOTICIA cn "
					+ "INNER JOIN TB_NOTICIA n ON n.id = cn.noticia_id "
					+ "INNER JOIN TB_CLIENTE c ON c.id = cn.cliente_id "
					+ "WHERE cn.cliente_id = :clienteId";
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("clienteId", clienteId);
			
			List<ClienteNoticia> clienteNoticias = template.query(sql, params, new ClienteNoticiaRowMapper());
			
			return clienteNoticias;
			
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
