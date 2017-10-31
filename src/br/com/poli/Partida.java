package br.com.poli;
import java.util.Date;
import java.util.Scanner;

import br.com.poli.exception.MovimentoIncorretoException;
import br.com.poli.exception.MovimentoInvalidoException;
import br.com.poli.exception.SemAjudaException;

public class Partida {

	private Jogador jogador;
	private Tabuleiro tabuleiro;
	private int quantidadeErros;
	private int quantidadeAjudas;
	private boolean venceu;
	private double tempo;
	private int score;
	private DificuldadePartida dificuldade;
	private double tempoInicial;
	private double tempoFinal;
	
	//Construtor vazio
	
	public Partida(){}
	
	//Construtor com atributos
	
	public Partida(Jogador jogador, Tabuleiro tabuleiro, DificuldadePartida dificuldade){
		this.jogador = jogador;
		this.tabuleiro = tabuleiro;
		this.dificuldade = dificuldade;
	}
	
	//Métodos
	
	
	public void executaMovimento(int x, int y, int valor) throws MovimentoInvalidoException, MovimentoIncorretoException{
		try{
			tabuleiro.executaMovimento(x, y, valor);
		}
		catch(MovimentoIncorretoException a){
			quantidadeErros++;
			
			throw new MovimentoIncorretoException("Movimento incorreto!\n");
			
		}
		venceu = tabuleiro.isTabuleiroPreenchido();
	}
	
	public void pedirAjuda() throws SemAjudaException{
		if(quantidadeAjudas > 0){
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
					if(tabuleiro.getGrid()[i][j] == 0){
						tabuleiro.getGrid()[i][j] = tabuleiro.getGabarito()[i][j];
						quantidadeAjudas--;
						return;
					}
				}
			}
		}
		else{
			throw new SemAjudaException("Sem mais pedidos de ajuda");
		}
	}
	
	
	public boolean isFimDeJogo(){
		if(this.quantidadeErros == dificuldade.getQuantidadeErros()){
			tempoFinal = System.currentTimeMillis();
			return true;
		}
		else{
			return false;
		}
	}
	
	public void iniciaPartida(){
		tempo = 0;
		quantidadeErros = 0;
		quantidadeAjudas = dificuldade.getAjudas();
		venceu = false;
		tabuleiro.geraTabuleiro(dificuldade);
		tempoInicial = System.currentTimeMillis();
	}
	
	//Gets
	public int getQuantidadeErros(){
		return quantidadeErros;
	}
	
	public Jogador getJogador(){
		return jogador;
	}
	
	public DificuldadePartida getDificuldade(){
		return dificuldade;
	}
	
	public double getTempo(){
		return tempo;
	}
	
	public void setTempoFinal(double tempo){
		this.tempoFinal = tempo;
	}
	
	public void setTempo(){
		this.tempo = (tempoFinal - tempoInicial)/ 1000;
	}
	
	public int getQuantidadeAjudas(){
		return quantidadeAjudas;
	}
	
}
