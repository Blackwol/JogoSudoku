package br.com.poli.exception;

@SuppressWarnings("serial")
public class MovimentoInvalidoException extends Exception {

	public MovimentoInvalidoException(String msg){
		super(msg);
	}
}
