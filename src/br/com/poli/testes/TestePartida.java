package br.com.poli.testes;


import br.com.poli.DificuldadePartida;
import br.com.poli.Jogador;
import br.com.poli.Partida;
import br.com.poli.Tabuleiro;
import br.com.poli.exception.MovimentoIncorretoException;
import br.com.poli.exception.MovimentoInvalidoException;

public class TestePartida {

	
	public static void main(String[] args) throws MovimentoInvalidoException, MovimentoIncorretoException{
		
		 //Criar objetos
		
		
		Jogador j1 = new Jogador(20, "Pedro");
		Tabuleiro t1 = new Tabuleiro();
		Partida p1 = new Partida(j1, t1, DificuldadePartida.NORMAL);

		
		//Execução
		System.out.println(p1.getQuantidadeErros() + "\n");
		System.out.println(p1.getJogador().getIdade());
		System.out.println(p1.getJogador().getNome());
		System.out.println("Quantidade de erros totais: " + p1.getDificuldade().getQuantidadeErros());
		
		
		
		try{
			p1.iniciaPartida();
			t1.imprimirTabuleiro();
			p1.isFimDeJogo();
			p1.executaMovimento(1, 1, 6);
			t1.imprimirTabuleiro();
			p1.executaMovimento(2, 5, 8);
			t1.imprimirTabuleiro();
		}catch(MovimentoInvalidoException e){
			System.out.println("Movimento invalido!");
		}
		catch(MovimentoIncorretoException a){
			System.out.println("Movimento incorreto!");
		}
	}
}
