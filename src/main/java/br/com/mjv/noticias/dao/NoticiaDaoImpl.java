package br.com.mjv.noticias.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.mjv.noticias.model.Noticia;
import br.com.mjv.noticias.model.mapper.NoticiaRowMapper;

@Repository
public class NoticiaDaoImpl implements NoticiaDao {
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public List<Noticia> lista() {
		
		String sql = "SELECT id, titulo, descricao FROM TB_NOTICIA";
						
		List<Noticia> noticias = template.query(sql, new MapSqlParameterSource(), new NoticiaRowMapper());
						
		return noticias;
	}

}
