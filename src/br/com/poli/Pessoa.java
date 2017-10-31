package br.com.poli;

public abstract class Pessoa {

	private int idade;
	private String nome;
	
	public Pessoa(int idade, String nome){
		this.idade = idade;
		this.nome = nome;
	}
	
	public Pessoa(){
		
	}
	
	//Gets e sets
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setIdade(int idade){
		this.idade = idade;
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getIdade(){
		return idade;
	}
	
}
