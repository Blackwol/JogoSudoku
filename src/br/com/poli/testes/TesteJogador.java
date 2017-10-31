package br.com.poli.testes;

import br.com.poli.Jogador;

public class TesteJogador {

	
	public static void main(String [] args){
		
		Jogador j1 = new Jogador(18, "Pedro");
		
		System.out.println("Nome jogador: " + j1.getNome());		
		
		System.out.println("Idade do jogador: " + j1.getIdade());
	}
}
