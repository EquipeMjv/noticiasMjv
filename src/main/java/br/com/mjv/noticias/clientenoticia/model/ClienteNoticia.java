package br.com.mjv.noticias.clientenoticia.model;

public class ClienteNoticia {

	private Long clienteId;
	private Long noticiaId;
	private String titulo;
	
	public Long getClienteId() {
		return clienteId;
	}
	
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	
	public Long getNoticiaId() {
		return noticiaId;
	}
	
	public void setNoticiaId(Long noticiaId) {
		this.noticiaId = noticiaId;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
