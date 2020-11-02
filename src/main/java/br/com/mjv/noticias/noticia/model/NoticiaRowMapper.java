package br.com.mjv.noticias.noticia.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;

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
		noticia.setDataCriacao(rs.getObject("data_criacao", OffsetDateTime.class));
		noticia.setDataAlteracao(rs.getObject("data_alteracao", OffsetDateTime.class));
		
		return noticia;
	}

}
