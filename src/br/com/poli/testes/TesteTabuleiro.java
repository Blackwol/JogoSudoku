package br.com.poli.testes;

import br.com.poli.DificuldadePartida;
import br.com.poli.Tabuleiro;
import br.com.poli.exception.MovimentoIncorretoException;
import br.com.poli.exception.MovimentoInvalidoException;
import br.com.poli.exception.SemSolucaoException;

public class TesteTabuleiro {

	
	public static void main(String[] args) throws MovimentoInvalidoException, MovimentoIncorretoException, SemSolucaoException{
		
		//Criar objetos
		DificuldadePartida dificuldade = null;
		
		
		
		Tabuleiro t1 = new Tabuleiro();

		
		
		//Testes métodos
		try{
			t1.geraTabuleiro(dificuldade.DIFICIL);
			t1.resolverTabuleiro(t1);  //Metodo que resolve tabuleiro sem gabarito
			t1.resolveTabuleiro();
			t1.imprimirTabuleiro();
			t1.isTabuleiroPreenchido();
		    t1.executaMovimento(1, 1, 10);
		}catch(MovimentoInvalidoException e){
			System.out.println("Movimento invalido!");
		}
		catch(MovimentoIncorretoException a){
			System.out.println("Movimento incorreto!");
		}
	}
}
