package br.com.poli;
import br.com.poli.exception.*;
import br.com.poli.interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tabuleiro implements ResolvedorSudoku {

	private int[][] gabarito = new int[9][9];
	private int[][] grid = new int[9][9];
	
	
	//Construtor vazio
	public Tabuleiro(){}
	
	//Construtor com atributos
	
	public Tabuleiro(int[][] gabarito){
		this.gabarito = gabarito;
	}
	
	
	//Métodos
	public void executaMovimento (int x, int y, int valor) throws MovimentoInvalidoException, MovimentoIncorretoException{
		
		if(x < 1 || x > 9){
			throw new MovimentoInvalidoException("Essa linha nao existe!");			
		}
		
		if(y < 1 || y > 9){
			throw new MovimentoInvalidoException("Essa coluna nao existe!");			
		}
		
		if(valor < 1 || valor > 9){
			throw new MovimentoInvalidoException("Valor errado!");
		}
		else if(grid[x - 1][y - 1] != 0){
			throw new MovimentoInvalidoException("Essa posiçao ja esta ocupada!");
		}
		else if(valor != gabarito[x - 1][y - 1]){
			throw new MovimentoIncorretoException("Jogada incorreta!");
		}
		else{
			grid[x - 1][y - 1] = valor;
			//System.out.println("Jogada feita\n");
		}
	}

	public boolean isTabuleiroPreenchido(){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(grid[i][j] == 0){
					return false;
				}
			}
		}
		return true;
	}
	
	
	//Método que resolve o grid sem o gabarito
	public void resolverTabuleiro(Tabuleiro puzzle) throws SemSolucaoException{
		String texto = "";
		int valor = 0;
		List<String> alteracoes = new ArrayList<String>();
		for (int x=0;x<9;x++){
			for (int y=0;y<9;y++){
				if(puzzle.getGrid()[x][y] == 0){
					if(valor == 0){
						valor = 1;
					}
					int valorAnterior = valor;
					//Verifica se o valor não está na linha
					for(int i=0;i<9;i++){
						if(puzzle.getGrid()[x][i] == valor){
							valor = valor + 1;
							i=0;
						}
					}
					//Verifica se o valor não está na coluna
					for(int i=0;i<9;i++){
						if(puzzle.getGrid()[i][y] == valor){
							valor = valor + 1;
							i=0;
						}
					}
					//Verifica se o valor não está em uma área 3x3
					if(x < 3){
						if(y < 3){
							for(int i=0;i<3;i++){
								for(int j=0;j<3;j++){
									if(puzzle.getGrid()[i][j] == valor){
										valor = valor + 1;
										i = 0;
										j = 0;
										break;
									}
								}
							}
						}else if(y < 6){
							for(int i=0;i<3;i++){
								for(int j=3;j<6;j++){
									if(puzzle.getGrid()[i][j] == valor){
										valor = valor + 1;
										i = 0;
										j = 3;
										break;
									}
								}
							}
						}else if(y < 9){
							for(int i=0;i<3;i++){
								for(int j=6;j<9;j++){
									if(puzzle.getGrid()[i][j] == valor){
										valor = valor + 1;
										i = 0;
										j = 6;
										break;
									}
								}
							}
						}
					}else if(x < 6){
						if(y < 3){
							for(int i=3;i<6;i++){
								for(int j=0;j<3;j++){
									if(puzzle.getGrid()[i][j] == valor){
										valor = valor + 1;
										i = 3;
										j = 0;
										break;
									}
								}
							}
						}else if(y < 6){
							for(int i=3;i<6;i++){
								for(int j=3;j<6;j++){
									if(puzzle.getGrid()[i][j] == valor){
										valor = valor + 1;
										i = 3;
										j = 3;
										break;
									}
								}
							}
						}else if(y < 9){
							for(int i=3;i<6;i++){
								for(int j=6;j<9;j++){
									if(puzzle.getGrid()[i][j] == valor){
										valor = valor + 1;
										i = 3;
										j = 6;
										break;
									}
								}
							}
						}
					}else if(x < 9){
						if(y < 3){
							for(int i=6;i<9;i++){
								for(int j=0;j<3;j++){
									if(puzzle.getGrid()[i][j] == valor){
										valor = valor + 1;
										i = 6;
										j = 0;
										break;
									}
								}
							}
						}else if(y < 6){
							for(int i=6;i<9;i++){
								for(int j=3;j<6;j++){
									if(puzzle.getGrid()[i][j] == valor){
										valor = valor + 1;
										i = 6;
										j = 3;
										break;
									}
								}
							}
						}else if(y < 9){
							for(int i=6;i<9;i++){
								for(int j=6;j<9;j++){
									if(puzzle.getGrid()[i][j] == valor){
										valor = valor + 1;
										i = 6;
										j = 6;
										break;
									}
								}
							}
						}
					}
					//Se não encontrar um valor válido então muda os valores anteriores
					if(valor > 9){
						x = Integer.parseInt(alteracoes.get(alteracoes.size()-1).substring(0,1));
						y = Integer.parseInt(alteracoes.get(alteracoes.size()-1).substring(1,2));
						alteracoes.remove(alteracoes.size()-1);
						valor = puzzle.getGrid()[x][y] + 1;
						puzzle.getGrid()[x][y] = 0;
						//Condição necessária para quando precisar voltar uma linha da matriz
						if(y == 0){
							x = x - 1;
							y = 9;
						}else{
							y = y - 1;
						}
					}else if(valor != valorAnterior){
						//Condição necessária para quando precisar voltar uma linha da matriz
						if(y == 0){
							x = x - 1;
							y = 9;
						}else{
							y = y - 1;
						}
					}else{
					//Se encontrar um valor válido, adiciona o campo alterado em uma lista de log e vai para o próximo número
						alteracoes.add(Integer.toString(x)+Integer.toString(y));
						puzzle.getGrid()[x][y] = valor;
						valor = 0;
					//Imprimir resultado na Tela
						texto = "";
						for(int i=0;i<9;i++){
							for(int j=0;j<9;j++){
								texto = "" + texto + Integer.toString(puzzle.getGrid()[i][j]);
								if(j == 2){
									texto = texto + " ";		
								}else if(j == 5){
									texto = texto + " ";
								}else if(j == 8){
									texto = texto + "\n";
								}
							}
							
						}
						
					}
				}
			}
		}
		System.out.println(texto);
		System.out.println("\n");
	}
	
	public void resolveTabuleiro(){
		String quadro = "";
        for (int i = 0; i < gabarito.length; i++)
        {
            for (int j = 0; j < gabarito[i].length; j++)
            {
            	quadro += " " + ((gabarito[i][j] < 0) ? -1 * gabarito[i][j] : gabarito[i][j]) + " ";
            }
            quadro += "\n";
        }
        System.out.println("" + quadro);
	}
	
	public void geraTabuleiro(DificuldadePartida dificuldade){
		Random random = new Random();
        final int n = 3;//aqui vai o numero de elementos do seu sudoku(3 vai ser um sudoku 3x3)
        int x = random.nextInt(100);//semente aleatória para não gerar o mesmo sudoku
        for (int i = 0; i < n; i++, x++){
            for (int j = 0; j < n; j++, x += n){
                for (int k = 0; k < n * n; k++, x++){
                    gabarito[n * i + j][k] = (x % (n * n)) + 1;
                }
            }
        }
        for(int i = 0; i < gabarito.length; i ++){
        	for(int j = 0; j < gabarito.length; j++){
        		grid[i][j] = gabarito[i][j];
        	}
        }
        if(dificuldade.getValor() == 1){
        	for(int i = 0, j = 0; i < 9; i++, j++){
        		grid[i][j] = 0;
        	} 
        	grid[1][8] = 0;
        	grid[8][2] = 0;
        	grid[4][1] = 0;
        	grid[7][3] = 0;
        	grid[2][7] = 0;
        }
        if(dificuldade.getValor() == 2){
        	for(int i = 0, j = 0; i < 9; i++, j++){
        		grid[i][j] = 0;
            }
        	for(int k = 0, e = 8; k < 9; k++, e--){
        		grid[k][e] = 0;
        	}
        	grid[1][8] = 0;
        	grid[8][2] = 0;
        	grid[4][1] = 0;
        	grid[7][3] = 0;
        	grid[2][7] = 0;
        }
        if(dificuldade.getValor() == 3){
        	for(int i = 0, j = 0; i < 9; i++, j++){
        		grid[i][j] = 0;
            }
        	for(int k = 0, e = 8; k < 9; k++, e--){
        		grid[k][e] = 0;
        	}
        	for(int i = 4, j = 0; j < 9; j++){
        		grid[i][j] = 0;
        	}
        	grid[1][8] = 0;
        	grid[8][2] = 0;
        	grid[4][1] = 0;
        	grid[7][3] = 0;
        	grid[2][7] = 0;
        }
	}
	
	public void imprimirTabuleiro(){
		String board = "";
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                board += " " + ((grid[i][j] < 0) ? -1 * grid[i][j] : grid[i][j]) + " ";
            }
            board += "\n";
        }
        System.out.println("" + board);
	}
	
	      //Gets e sets
	
	public void setGabarito(int[][] gabarito){
		this.gabarito = gabarito;
	}
	
	public void setGrid(int[][] grid){
		this.grid = grid;
	}
	
	public int[][] getGabarito(){
		return gabarito;
	}
	
	public int[][] getGrid(){
		return grid;
	}
	
	
}
