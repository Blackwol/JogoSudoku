package br.com.poli;

import br.com.poli.interfaces.CalculaScore;

public class CalculaScoreComIdade implements CalculaScore{
	private double score;

	
	public void Calcula(Partida p){
		
		long idadeJogador = p.getJogador().getIdade();
		long erros = p.getQuantidadeErros();
		long dificuldade = p.getDificuldade().getValor();
		double duracao = p.getTempo();
		long ajudas = p.getQuantidadeAjudas();
		
		score = (dificuldade*10000 + ajudas) - (duracao + erros + idadeJogador);
		
	}
	
	public double getScore(){
		return score;
	}
}
