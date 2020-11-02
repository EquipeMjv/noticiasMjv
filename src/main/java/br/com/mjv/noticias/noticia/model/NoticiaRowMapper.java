package br.com.mjv.noticias.noticia.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * classe RowMapper da classe de modelo {@link Noticia} da tabela TB_NOTICIA
 * @author thiago
 *
 */

public class NoticiaRowMapper implements RowMapper<Noticia> {

	@Override
	public Noticia mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Noticia noticia = new Noticia();
		noticia.setId(rs.getLong("id"));
		noticia.setTitulo(rs.getString("titulo"));
		noticia.setDescricao(rs.getString("descricao"));
		noticia.setImagem(rs.getString("imagem"));
		
		return noticia;
	}

}
