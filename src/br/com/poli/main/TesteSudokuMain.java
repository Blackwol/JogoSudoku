package br.com.poli.main;
import br.com.poli.*;
import br.com.poli.exception.MovimentoIncorretoException;
import br.com.poli.exception.MovimentoInvalidoException;

import java.util.Scanner;

public class TesteSudokuMain {

	public static void main(String[] args) throws MovimentoInvalidoException, MovimentoIncorretoException{
		
		
		Scanner entrada = new Scanner(System.in);
		int opcao;
		do{            //Menu inicial para escolher a opçao
			System.out.println("1. Iniciar jogo");
			System.out.println("0. Sair");
			System.out.println("Digite sua opçao: ");
			opcao = entrada.nextInt();
			switch(opcao){
			case 1:
				jogar();
				break;
			case 0:
				System.out.println("Encerrando programa");
				System.exit(0);
				break;
			default:
			    System.out.println("Opçao invalida! Digite uma opçao valida: ");		
			}
		}while(opcao < 0 || opcao > 1);
	}
	
	public static void jogar() throws MovimentoInvalidoException, MovimentoIncorretoException{
		System.out.println("------CRIANDO JOGADOR------");  //Se optar por jogar vai ser criado um jogador
		Scanner x = new Scanner(System.in);
		System.out.println("Digite seu nome: ");
		String nome = x.nextLine();
		Scanner y = new Scanner(System.in);
		System.out.println("Digite sua idade:");
		int idade = y.nextInt();
		Jogador jogador = new Jogador(idade, nome);
		Tabuleiro tabuleiro = new Tabuleiro();
		System.out.println("Escolha a dificuldade: ");
		System.out.println("1. Facil\n2. Normal\n3. Dificil");
		Scanner z = new Scanner(System.in);
		int opcaoZ = z.nextInt();
		switch(opcaoZ){
		case 1:      //Se for escolhido a dificuldade Facil
			Partida partida1 = new Partida(jogador, tabuleiro, DificuldadePartida.FACIL);
			partida1.iniciaPartida();
			tabuleiro.imprimirTabuleiro();  //Começo do jogo ele imprime o jogo e pergunta se vc quer o gabarito ou continuar o jogo
			System.out.println("Digite 1 para mostrar o gabarito\nSe não quiser o gabarito, digite qualquer outro numero para começar o jogo");
			Scanner entrada4 = new Scanner(System.in);
			int gabarito = entrada4.nextInt();
			switch(gabarito){
			case 1:   //Se quiser o gabarito ele imprime a resposta e acaba o jogo
				tabuleiro.resolveTabuleiro();
				System.out.println("Fim de jogo!");
				break;
			default:   //Continua o jogo normalmente
				do{
					tabuleiro.imprimirTabuleiro();
					try{
						System.out.println("Digite a linha da jogada: ");
						Scanner entrada1 = new Scanner(System.in);
						int x1 = entrada1.nextInt();
						System.out.println("Digite a coluna da jogada: ");
						Scanner entrada2 = new Scanner(System.in);
						int y1 = entrada2.nextInt();
						System.out.println("Digite o valor da jogada: ");
						Scanner entrada3 = new Scanner(System.in);
						int valor = entrada3.nextInt();
						partida1.executaMovimento(x1, y1, valor);
					}catch(MovimentoInvalidoException a){
						System.out.println("Movimento invalido!");
					}
					catch(MovimentoIncorretoException a){
						System.out.println("Movimento incorreto!");
					}
					
					System.out.println("Voce ja tem: " + partida1.getQuantidadeErros() + " erros de um total de: " + partida1.getDificuldade().getQuantidadeErros());
				}while(tabuleiro.isTabuleiroPreenchido() == false && partida1.isFimDeJogo() == false );
				if(tabuleiro.isTabuleiroPreenchido() == true){  //Se o jogador ganhar entra nesse loop
					partida1.setTempoFinal(System.currentTimeMillis());
					partida1.setTempo();
					CalculaScoreSemIdade c1 = new CalculaScoreSemIdade();
					System.out.println("Parabens " + partida1.getJogador().getNome() + "!!" + " Voce venceu em " + partida1.getTempo() + " segundos!!");
					c1.Calcula(partida1);
				}
				if(partida1.isFimDeJogo() == true){   //Se o jogador perder entra nesse loop
					partida1.setTempoFinal(System.currentTimeMillis());
					partida1.setTempo();
					System.out.println("Que pena! Voce perdeu =/");
				}	
			}
			break;
		case 2:   //Se escolher a dificuldade Media, mesma coisa do "case 1"
			Partida partida2 = new Partida(jogador, tabuleiro, DificuldadePartida.NORMAL);
			partida2.iniciaPartida();
			tabuleiro.imprimirTabuleiro();
			System.out.println("Digite 1 para mostrar o gabarito\nSe não quiser o gabarito, digite qualquer outro numero para começar o jogo");
			Scanner entrada5 = new Scanner(System.in);
			int gabarito2 = entrada5.nextInt();
			switch(gabarito2){
			case 1:
				tabuleiro.resolveTabuleiro();
				System.out.println("Fim de jogo!");
				break;
			default:
				do{
					tabuleiro.imprimirTabuleiro();
					try{
						System.out.println("Digite a linha da jogada: ");
						Scanner entrada1 = new Scanner(System.in);
						int x1 = entrada1.nextInt();
						System.out.println("Digite a coluna da jogada: ");
						Scanner entrada2 = new Scanner(System.in);
						int y1 = entrada2.nextInt();
						System.out.println("Digite o valor da jogada: ");
						Scanner entrada3 = new Scanner(System.in);
						int valor = entrada3.nextInt();
						partida2.executaMovimento(x1, y1, valor);
					}catch(MovimentoInvalidoException a){
						System.out.println("Movimento invalido!");
					}
					catch(MovimentoIncorretoException a){
						System.out.println("Movimento incorreto!");
					}
					
					System.out.println("Voce ja tem: " + partida2.getQuantidadeErros() + " erros de um total de: " + partida2.getDificuldade().getQuantidadeErros());
				}while(tabuleiro.isTabuleiroPreenchido() == false && partida2.isFimDeJogo() == false );
				if(tabuleiro.isTabuleiroPreenchido() == true){
					partida2.setTempoFinal(System.currentTimeMillis());
					partida2.setTempo();
					CalculaScoreSemIdade c2 = new CalculaScoreSemIdade();
					System.out.println("Parabens " + partida2.getJogador().getNome() + "!!" + " Voce venceu em " + partida2.getTempo() + " segundos!!");
					c2.Calcula(partida2);
				}
				if(partida2.isFimDeJogo() == true){
					partida2.setTempoFinal(System.currentTimeMillis());
					partida2.setTempo();
					System.out.println("Que pena! Voce perdeu =/");
				}	
			}
			break;
		case 3:    //Se escolher a diciculdade Dificil, mesma coisa do "case 1" e "case 2"
			Partida partida3 = new Partida(jogador, tabuleiro, DificuldadePartida.DIFICIL);
			partida3.iniciaPartida();
			tabuleiro.imprimirTabuleiro();
			System.out.println("Digite 1 para mostrar o gabarito\nSe não quiser o gabarito, digite qualquer outro numero para começar o jogo");
			Scanner entrada6 = new Scanner(System.in);
			int gabarito3 = entrada6.nextInt();
			switch(gabarito3){
			case 1:
				tabuleiro.resolveTabuleiro();
				System.out.println("Fim de jogo!");
				break;
			default:
				do{
					tabuleiro.imprimirTabuleiro();
					try{
						System.out.println("Digite a linha da jogada: ");
						Scanner entrada1 = new Scanner(System.in);
						int x1 = entrada1.nextInt();
						System.out.println("Digite a coluna da jogada: ");
						Scanner entrada2 = new Scanner(System.in);
						int y1 = entrada2.nextInt();
						System.out.println("Digite o valor da jogada: ");
						Scanner entrada3 = new Scanner(System.in);
						int valor = entrada3.nextInt();
						partida3.executaMovimento(x1, y1, valor);
					}catch(MovimentoInvalidoException a){
						System.out.println("Movimento invalido!");
					}
					catch(MovimentoIncorretoException a){
						System.out.println("Movimento incorreto!");
					}
					
					System.out.println("Voce ja tem: " + partida3.getQuantidadeErros() + " erros de um total de: " + partida3.getDificuldade().getQuantidadeErros());
				}while(tabuleiro.isTabuleiroPreenchido() == false && partida3.isFimDeJogo() == false );
				if(tabuleiro.isTabuleiroPreenchido() == true){
					partida3.setTempoFinal(System.currentTimeMillis());
					partida3.setTempo();
					CalculaScoreSemIdade c3 = new CalculaScoreSemIdade();
					System.out.println("Parabens " + partida3.getJogador().getNome() + "!!" + " Voce venceu em " + partida3.getTempo() + " segundos!!");
					c3.Calcula(partida3);
				}
				if(partida3.isFimDeJogo() == true){
					partida3.setTempoFinal(System.currentTimeMillis());
					partida3.setTempo();
					System.out.println("Que pena! Voce perdeu =/");
				}	
			}
			break;
		default:
		    System.out.println("Opcao errada! Digite uma opçao correta: ");	
		}	
	}
}
