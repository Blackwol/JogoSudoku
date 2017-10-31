package br.com.poli;

public enum DificuldadePartida {

	FACIL(1, 7, 4), NORMAL(2, 5, 3), DIFICIL(3, 3, 2);
	
	private final int valor;
	private final int quantidadeErros;
	private final int ajudas;
	
	
	DificuldadePartida(int valor, int quantidadeErros, int ajudas){
		this.valor = valor;
		this.quantidadeErros = quantidadeErros;
		this.ajudas = ajudas;
	}
	
	   //Getters
	
	public int getValor(){
		return valor;
	}
	
	public int getQuantidadeErros(){
		return quantidadeErros;
	}
	
	public  int getAjudas(){
		return ajudas;
	}
}
