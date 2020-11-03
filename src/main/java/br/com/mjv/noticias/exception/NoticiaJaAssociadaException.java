package br.com.mjv.noticias.exception;

public class NoticiaJaAssociadaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoticiaJaAssociadaException(String message) {
		super(message);
	}
	
	public NoticiaJaAssociadaException(String message, Long id) {
		this(String.format("Noticia de id %d já foi cadastrada no seu perfil", id));
	}
	
}
