package br.com.poli.interfaces;
import br.com.poli.Tabuleiro;
import br.com.poli.exception.SemSolucaoException;

public interface ResolvedorSudoku {

	
	public void resolverTabuleiro(Tabuleiro t) throws SemSolucaoException;

}
