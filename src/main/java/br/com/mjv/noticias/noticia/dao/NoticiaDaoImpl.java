package br.com.mjv.noticias.noticia.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.mjv.noticias.noticia.model.Noticia;
import br.com.mjv.noticias.noticia.model.NoticiaRowMapper;

@Repository
public class NoticiaDaoImpl implements NoticiaDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NoticiaDaoImpl.class);
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private DataSource ds;

	@Override
	public List<Noticia> listarTodos() {
		
		String sql = "SELECT id, titulo, descricao, imagem, data_criacao, data_alteracao FROM TB_NOTICIA "
				+ "ORDER BY data_criacao DESC";
						
		List<Noticia> noticias = template.query(sql, new MapSqlParameterSource(), new NoticiaRowMapper());
						
		return noticias;
	}

	@Override
	public Page<Noticia> listarTodos(Pageable pageable) {
		
		Integer totalPorPagina = pageable.getPageSize();
		Long inicio = pageable.getOffset();
		
		String sql = "SELECT id, titulo, descricao, imagem, data_criacao, data_alteracao FROM TB_NOTICIA "
				+ "LIMIT :totalPorPagina OFFSET :inicio ORDER BY data_criacao DESC";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("totalPorPagina", totalPorPagina);
		params.addValue("inicio", inicio);
		
		List<Noticia> noticias = template.query(sql, params, new NoticiaRowMapper());
						
		return new PageImpl<>(noticias, pageable, totalRegistros());
	}

	private Integer totalRegistros() {
		
		String sql = "SELECT COUNT(*) FROM TB_NOTICIA";
		
		return template.queryForObject(sql, new MapSqlParameterSource(), Integer.class);
	}

	@Override
	public Long adicionar(Noticia noticia) {
		
		SimpleJdbcInsert insertCliente = new SimpleJdbcInsert(ds).usingGeneratedKeyColumns("id");
		insertCliente.withTableName("TB_NOTICIA");
		
		Map<String, Object> params = new HashMap<>();
		params.put("titulo", noticia.getTitulo());
		params.put("descricao", noticia.getDescricao());
		params.put("imagem", noticia.getImagem());
		params.put("data_criacao", noticia.getDataCriacao());
		params.put("data_alteracao", noticia.getDataAlteracao());
		
		Long result = (Long) insertCliente.executeAndReturnKey(params);
		
		return result;
	}

	@Override
	public Noticia buscarPorId(Long noticiaId) {
		try {
			String sql = "SELECT id, titulo, descricao, imagem, data_criacao, data_alteracao FROM TB_NOTICIA "
					+ "WHERE id = :noticiaId";
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("noticiaId", noticiaId);
			
			Noticia noticia = template.queryForObject(sql, params, new NoticiaRowMapper());
			
			return noticia;
		} catch (EmptyResultDataAccessException e) {
			LOGGER.error(String.format("Não foi encontrada noticia de id %d cadastrada.", noticiaId));
			return null;
		}
	}

}
