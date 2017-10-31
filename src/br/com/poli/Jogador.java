package br.com.poli;

public class Jogador extends Pessoa {

	private int scoreRecorde;
	
    //Construtor vazio
    public Jogador(){}
	
	//Construtor com atributos
	public Jogador(int idade, String nome){
		super(idade, nome);
	}
	
	
	    //Gets e sets
	
	public void setScoreRecorde(int score){
		this.scoreRecorde = score;
	}
	
	
	public int getScoreRecorde(){
		return scoreRecorde;
	}
}
