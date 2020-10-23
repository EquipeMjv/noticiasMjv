package br.com.mjv.noticias.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.mjv.noticias.model.Noticia;

public class NoticiaRowMapper implements RowMapper<Noticia> {

	@Override
	public Noticia mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Noticia noticia = new Noticia();
		noticia.setId(rs.getLong("id"));
		noticia.setTitulo(rs.getString("titulo"));
		noticia.setDescricao(rs.getString("descricao"));		
		
		return noticia;
	}

}
