package br.com.mjv.noticias.noticia.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.mjv.noticias.noticia.model.Noticia;
import br.com.mjv.noticias.noticia.model.NoticiaRowMapper;

@Repository
public class NoticiaDaoImpl implements NoticiaDao {
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public List<Noticia> listarTodos() {
		
		String sql = "SELECT id, titulo, descricao FROM TB_NOTICIA";
						
		List<Noticia> noticias = template.query(sql, new MapSqlParameterSource(), new NoticiaRowMapper());
						
		return noticias;
	}

	@Override
	public Page<Noticia> listarTodos(Pageable pageable) {
		
		Integer totalPorPagina = pageable.getPageSize();
		Long inicio = pageable.getOffset();
		
		String sql = "SELECT id, titulo, descricao FROM TB_NOTICIA LIMIT :totalPorPagina OFFSET :inicio";
		
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

}
