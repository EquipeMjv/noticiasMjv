package br.com.mjv.noticias.noticia.model;

import java.time.OffsetDateTime;

/**
 * classe de modelo da tabela TB_NOTICIA
 * @author thiago
 *
 */

public class Noticia {

	private Long id;
	private String titulo;
	private String descricao;
	private String imagem;
	private OffsetDateTime dataCriacao;
	private OffsetDateTime dataAlteracao;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public OffsetDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(OffsetDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public OffsetDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(OffsetDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
		
}
