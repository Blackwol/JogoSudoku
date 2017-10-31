package br.com.poli.exception;

@SuppressWarnings("serial")
public class MovimentoIncorretoException extends Exception {

	public MovimentoIncorretoException(String msg){
		super(msg);
	}
}
