package br.com.mjv.noticias.clientenoticia.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.mjv.noticias.clientenoticia.model.ClienteNoticia;
import br.com.mjv.noticias.clientenoticia.model.ClienteNoticiaRowMapper;

@Repository
public class ClienteNoticiaDaoImpl implements ClienteNoticiaDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteNoticiaDaoImpl.class);
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public List<ClienteNoticia> listarNoticiasPorIdCliente(Long clienteId) {
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
			LOGGER.error(String.format("Não foi encontrado noticias cadastradas para o cliente de id %d ", clienteId));
			return null;
		}
	}

	@Override
	public ClienteNoticia buscarNoticiaPorIdCliente(Long clienteId, Long noticiaId) {
		try {
			String sql = "SELECT cliente_id, noticia_id, titulo FROM TB_CLIENTE_NOTICIA cn "
					+ "INNER JOIN TB_NOTICIA n ON n.id = cn.noticia_id "
					+ "INNER JOIN TB_CLIENTE c ON c.id = cn.cliente_id "
					+ "WHERE cn.cliente_id = :clienteId AND cn.noticia_id = :noticiaId";
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("clienteId", clienteId);
			params.addValue("noticiaId", noticiaId);
			
			ClienteNoticia clienteNoticia = template.queryForObject(sql, params, new ClienteNoticiaRowMapper());
			
			return clienteNoticia;
			
		} catch (EmptyResultDataAccessException e) {
			LOGGER.error(String.format("Não foi encontrado noticia de id %d cadastrada para o cliente de %d ", noticiaId, clienteId));
			return null;
		}
	}
	
	@Override
	public void associarNoticia(Long clienteId, Long noticiaId) {
		String sql = "INSERT INTO TB_CLIENTE_NOTICIA (cliente_id, noticia_id) VALUES (:clienteId, :noticiaId)";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("clienteId", clienteId);
		params.addValue("noticiaId", noticiaId);
		
		template.update(sql, params);
	}

}
