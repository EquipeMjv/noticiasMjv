package br.com.mjv.noticias.login.model;

/**
 * Modelo DTO utilizado para o processo de login
 * @author thiago
 *
 */

public class Login {
	
	private String usuario;
	private String senha;
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
