package br.com.poli;

import br.com.poli.interfaces.CalculaScore;

public class CalculaScoreSemIdade implements CalculaScore{
	private double score;

	public void Calcula(Partida p){
		
		long erros = p.getQuantidadeErros();
		long dificuldade = p.getDificuldade().getValor();
		double duracao = p.getTempo();
		long ajudas = p.getQuantidadeAjudas();
		
		double score = (dificuldade*1000 + ajudas) - (duracao + erros);
		
	}
	
	public double getScore(){
		return score;
	}
}
