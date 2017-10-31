package br.com.poli.interfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import br.com.poli.*;
import br.com.poli.exception.MovimentoIncorretoException;
import br.com.poli.exception.MovimentoInvalidoException;
import br.com.poli.exception.SemAjudaException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class View {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panelMenu;
	private JPanel panelCriacaoJogo;
	private JPanel panelPartidaFacil;
	private JPanel panelPartidaNormal;
	private JPanel panelPartidaDificil;
	private String nome;
	private int idade;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private Partida partida;
	private Tabuleiro tabuleiro;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel panelMenu = new JPanel();
		frame.getContentPane().add(panelMenu, "name_952432441934036");
		panelMenu.setLayout(null);
		
		JLabel lblBemVindoAo = new JLabel("Bem vindo ao Sudoku!");
		lblBemVindoAo.setBounds(159, 28, 154, 31);
		panelMenu.add(lblBemVindoAo);
		
		
		
		final JPanel panelCriacaoJogo = new JPanel();
		frame.getContentPane().add(panelCriacaoJogo, "name_952436266558617");
		panelCriacaoJogo.setLayout(null);
		
		JLabel lblDigiteSeuNome = new JLabel("Digite seu nome");
		lblDigiteSeuNome.setBounds(47, 44, 94, 14);
		panelCriacaoJogo.add(lblDigiteSeuNome);
		
		textField = new JTextField();
		textField.setBounds(168, 41, 194, 20);
		panelCriacaoJogo.add(textField);
		textField.setColumns(10);
		
		JLabel lblDigiteSuaIdade = new JLabel("Digite sua idade");
		lblDigiteSuaIdade.setBounds(47, 94, 94, 14);
		panelCriacaoJogo.add(lblDigiteSuaIdade);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 91, 194, 20);
		panelCriacaoJogo.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEscolhaADificuldade = new JLabel("Escolha a dificuldade da partida. Quando clicar no bot\u00E3o a partida ira come\u00E7ar");
		lblEscolhaADificuldade.setBounds(28, 161, 396, 14);
		panelCriacaoJogo.add(lblEscolhaADificuldade);
		
		JButton btnNormal = new JButton("Normal"); 
		btnNormal.setBounds(168, 186, 89, 23);
		panelCriacaoJogo.add(btnNormal);
		
		
		final JPanel panelPartidaFacil = new JPanel();
		frame.getContentPane().add(panelPartidaFacil, "name_952439932273092");
		panelPartidaFacil.setLayout(null);
		
		JButton btnDesistir = new JButton("Desistir");
		btnDesistir.setBounds(24, 39, 89, 23);
		panelPartidaFacil.add(btnDesistir);
		
		textField_11 = new JTextField();
		textField_11.setBounds(24, 80, 86, 20);
		panelPartidaFacil.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblX = new JLabel("x");
		lblX.setBounds(120, 83, 46, 14);
		panelPartidaFacil.add(lblX);
		
		textField_12 = new JTextField();
		textField_12.setBounds(24, 100, 86, 20);
		panelPartidaFacil.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblY = new JLabel("y");
		lblY.setBounds(120, 103, 46, 14);
		panelPartidaFacil.add(lblY);
		
		textField_13 = new JTextField();
		textField_13.setBounds(24, 120, 86, 20);
		panelPartidaFacil.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblValor = new JLabel("valor");
		lblValor.setBounds(120, 123, 46, 14);
		panelPartidaFacil.add(lblValor);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(260, 11, 143, 186);
		panelPartidaFacil.add(textArea_1);
		
		
	
		
		JButton btnFazerJogada = new JButton("Fazer jogada");   //BOTAO FAZER JOGADA PARTIDA FACIL
		btnFazerJogada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int x, y, valor;
					x = Integer.parseInt(textField_11.getText());
					y = Integer.parseInt(textField_12.getText());
					valor = Integer.parseInt(textField_13.getText());
					partida.executaMovimento(x, y, valor);
					JOptionPane.showMessageDialog(null, "Jogada feita!");
					String s = "";
					for(int i = 0; i < 9; i++){
						for(int j = 0; j < 9; j++){
							s +=tabuleiro.getGrid()[i][j];
							s +=" ";
						}
						s +="\n";
					}
					textArea_1.setText(s);
					
					
				} catch (MovimentoInvalidoException a) {
					JOptionPane.showMessageDialog(null, "Movimento invalido!");
				}catch(MovimentoIncorretoException i){
					JOptionPane.showMessageDialog(null, "Movimento incorreto!");
				}catch(Exception o){
					JOptionPane.showMessageDialog(null, "Movimento invalido!");
				}
				String q = "";
				partida.setTempoFinal(System.currentTimeMillis());
				partida.setTempo();
				q += partida.getTempo();
				textField_14.setText(q);
				String p = "";
				p += partida.getQuantidadeErros();
				textField_10.setText(p);
				if(partida.isFimDeJogo() == true){
					String w = "Voce perdeu " + partida.getJogador().getNome() + " =/\n";
					for(int i = 0; i < 9; i++){
						for(int j = 0; j < 9; j++){
							w +=tabuleiro.getGabarito()[i][j];
							w +=" ";
						}
						w +="\n";
					}
					JOptionPane.showMessageDialog(null, w);
					panelPartidaFacil.setVisible(false);
					panelMenu.setVisible(true);
				}
				if(tabuleiro.isTabuleiroPreenchido() == true){
                    CalculaScoreComIdade score = new CalculaScoreComIdade();
					partida.setTempoFinal(System.currentTimeMillis());
					partida.setTempo();
					score.Calcula(partida);
					String b = "Parabens " + partida.getJogador().getNome() +"! Voce venceu!\n" + "Seu score foi de " + score.getScore();
					JOptionPane.showMessageDialog(null, b);
					panelPartidaFacil.setVisible(false);
					panelMenu.setVisible(true);
				}
				
			}
		});
		panelPartidaFacil.add(btnFazerJogada);
		btnFazerJogada.setBounds(24, 151, 113, 23);	
		
		JButton btnPedriAjuda = new JButton("Pedir ajuda");   //BOTAO PEDIR AJUDA PARTIDA FACIL
		btnPedriAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					partida.pedirAjuda();
					String s = "";
					for(int i = 0; i < 9; i++){
						for(int j = 0; j < 9; j++){
							s +=tabuleiro.getGrid()[i][j];
							s +=" ";
						}
						s +="\n";
					}
					textArea_1.setText(s);
				}catch(SemAjudaException a){
					JOptionPane.showMessageDialog(null, "Voce nao tem mais pedidos de ajuda");
				}
				String q = "";
				partida.setTempoFinal(System.currentTimeMillis());
				partida.setTempo();
				q += partida.getTempo();
				textField_14.setText(q);
				if(partida.isFimDeJogo() == true){
					panelPartidaFacil.setVisible(false);
					panelMenu.setVisible(true);
					JOptionPane.showMessageDialog(null, "Voce perdeu! =/");
				}
				if(tabuleiro.isTabuleiroPreenchido() == true){
					CalculaScoreComIdade score = new CalculaScoreComIdade();
					partida.setTempoFinal(System.currentTimeMillis());
					partida.setTempo();
					score.Calcula(partida);
					String b = "Parabens " + partida.getJogador().getNome() +"! Voce venceu!\n" + "Seu score foi de " + score.getScore();
					JOptionPane.showMessageDialog(null, b);
					panelPartidaFacil.setVisible(false);
					panelMenu.setVisible(true);
				}
			}
		});
		btnPedriAjuda.setBounds(24, 185, 100, 23);
		panelPartidaFacil.add(btnPedriAjuda);
		
		JLabel lblErros_2 = new JLabel("Erros");
		lblErros_2.setBounds(24, 224, 56, 14);
		panelPartidaFacil.add(lblErros_2);
		
		textField_10 = new JTextField();
		textField_10.setBounds(80, 221, 86, 20);
		panelPartidaFacil.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblTempoDecorrido = new JLabel("Tempo decorrido");
		lblTempoDecorrido.setBounds(205, 224, 100, 14);
		panelPartidaFacil.add(lblTempoDecorrido);
		
		textField_14 = new JTextField();
		textField_14.setBounds(317, 221, 86, 20);
		panelPartidaFacil.add(textField_14);
		textField_14.setColumns(10);
		
		
		
		final JPanel panelPartidaNormal = new JPanel();
		frame.getContentPane().add(panelPartidaNormal, "name_954640603412867");
		panelPartidaNormal.setLayout(null);
		
		JButton btnDesistir_1 = new JButton("Desistir");  //DESISTIR PARTIDA NORMAL
		btnDesistir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = "";
				for(int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
						s +=tabuleiro.getGabarito()[i][j];
						s +=" ";
					}
					s +="\n";
				}
				JOptionPane.showMessageDialog(null, s);
				panelPartidaNormal.setVisible(false);
				panelMenu.setVisible(true);				
			}
		});
		btnDesistir_1.setBounds(23, 27, 89, 23);
		panelPartidaNormal.add(btnDesistir_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(26, 61, 86, 20);
		panelPartidaNormal.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblX_1 = new JLabel("x");
		lblX_1.setBounds(122, 64, 46, 14);
		panelPartidaNormal.add(lblX_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(26, 83, 86, 20);
		panelPartidaNormal.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblY_1 = new JLabel("y");
		lblY_1.setBounds(122, 87, 46, 14);
		panelPartidaNormal.add(lblY_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(26, 105, 86, 20);
		panelPartidaNormal.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblValor_1 = new JLabel("valor");
		lblValor_1.setBounds(122, 106, 46, 14);
		panelPartidaNormal.add(lblValor_1);
		
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(290, 26, 116, 178);
		panelPartidaNormal.add(textArea);
		
		JButton btnFazerJogada_1 = new JButton("Fazer jogada");   //FAZER JOGADA PARTIDA NORMAL
		btnFazerJogada_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int x, y, valor;
					x = Integer.parseInt(textField_3.getText());
					y = Integer.parseInt(textField_4.getText());
					valor = Integer.parseInt(textField_5.getText());
					partida.executaMovimento(x, y, valor);
					JOptionPane.showMessageDialog(null, "Jogada feita!");
					String s = "";
					for(int i = 0; i < 9; i++){
						for(int j = 0; j < 9; j++){
							s +=tabuleiro.getGrid()[i][j];
							s +=" ";
						}
						s +="\n";
					}
					textArea.setText(s);
				} catch (MovimentoInvalidoException a) {
					JOptionPane.showMessageDialog(null, "Movimento invalido!");
				}catch(MovimentoIncorretoException i){
					JOptionPane.showMessageDialog(null, "Movimento incorreto!");
				}catch(Exception o){
					JOptionPane.showMessageDialog(null, "Movimento invalido!");
				}
				String q = "";
				partida.setTempoFinal(System.currentTimeMillis());
				partida.setTempo();
				q += partida.getTempo();
				textField_15.setText(q);
				String p = "";
				p += partida.getQuantidadeErros();
				textField_9.setText(p);
				if(partida.isFimDeJogo() == true){
					String w = "Voce perdeu " + partida.getJogador().getNome() + " =/\n";
					for(int i = 0; i < 9; i++){
						for(int j = 0; j < 9; j++){
							w +=tabuleiro.getGabarito()[i][j];
							w +=" ";
						}
						w +="\n";
					}
					JOptionPane.showMessageDialog(null, w);
					panelPartidaNormal.setVisible(false);
					panelMenu.setVisible(true);
				}
				if(tabuleiro.isTabuleiroPreenchido() == true){
					CalculaScoreComIdade score = new CalculaScoreComIdade();
					partida.setTempoFinal(System.currentTimeMillis());
					partida.setTempo();
					score.Calcula(partida);
					String b = "Parabens " + partida.getJogador().getNome() +"! Voce venceu!\n" + "Seu score foi de " + score.getScore();
					JOptionPane.showMessageDialog(null, b);
					panelPartidaNormal.setVisible(false);
					panelMenu.setVisible(true);
				}
			}
		});
		btnFazerJogada_1.setBounds(23, 136, 116, 23);
		panelPartidaNormal.add(btnFazerJogada_1);
		
		JButton btnPedirAjuda_1 = new JButton("Pedir ajuda");       //BOTAO PEDIR AJUDA PARTIDA NORMAL
		btnPedirAjuda_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					partida.pedirAjuda();
					String s = "";
					for(int i = 0; i < 9; i++){
						for(int j = 0; j < 9; j++){
							s +=tabuleiro.getGrid()[i][j];
							s +=" ";
						}
						s +="\n";
					}
					textArea.setText(s);
				}catch(SemAjudaException a){
					JOptionPane.showMessageDialog(null, "Voce nao tem mais pedidos de ajuda");
				}
				String q = "";
				partida.setTempoFinal(System.currentTimeMillis());
				partida.setTempo();
				q += partida.getTempo();
				textField_15.setText(q);				
				if(tabuleiro.isTabuleiroPreenchido() == true){
					CalculaScoreComIdade score = new CalculaScoreComIdade();
					partida.setTempoFinal(System.currentTimeMillis());
					partida.setTempo();
					score.Calcula(partida);
					String b = "Parabens " + partida.getJogador().getNome() +"! Voce venceu!\n" + "Seu score foi de " + score.getScore();
					JOptionPane.showMessageDialog(null, b);
					panelPartidaNormal.setVisible(false);
					panelMenu.setVisible(true);
				}
			}
		});
		
		
		btnPedirAjuda_1.setBounds(23, 170, 116, 23);
		panelPartidaNormal.add(btnPedirAjuda_1);
		
		JLabel lblErros_1 = new JLabel("Erros");
		lblErros_1.setBounds(23, 219, 55, 14);
		panelPartidaNormal.add(lblErros_1);
		
		textField_9 = new JTextField();
		textField_9.setBounds(69, 216, 86, 20);
		panelPartidaNormal.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblTempoDecorrido_1 = new JLabel("Tempo decorrido");
		lblTempoDecorrido_1.setBounds(197, 219, 98, 14);
		panelPartidaNormal.add(lblTempoDecorrido_1);
		
		textField_15 = new JTextField();
		textField_15.setBounds(290, 216, 86, 20);
		panelPartidaNormal.add(textField_15);
		textField_15.setColumns(10);
		
		
		final JPanel panelPartidaDificil = new JPanel();
		frame.getContentPane().add(panelPartidaDificil, "name_954662210038740");
		panelPartidaDificil.setLayout(null);
		
		JButton btnDesistir_2 = new JButton("Desistir");  //BOTAO DESISTIR PARTIDA DIFICIL
		btnDesistir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = "";
				for(int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
						s +=tabuleiro.getGabarito()[i][j];
						s +=" ";
					}
					s +="\n";
				}
				panelPartidaDificil.setVisible(false);
				panelMenu.setVisible(true);
				JOptionPane.showMessageDialog(null, s);
			}
		});
		btnDesistir_2.setBounds(33, 30, 89, 23);
		panelPartidaDificil.add(btnDesistir_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(33, 64, 86, 20);
		panelPartidaDificil.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblX_2 = new JLabel("x");
		lblX_2.setBounds(129, 67, 46, 14);
		panelPartidaDificil.add(lblX_2);
		
		textField_6 = new JTextField();
		textField_6.setBounds(33, 95, 86, 20);
		panelPartidaDificil.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblY_2 = new JLabel("y");
		lblY_2.setBounds(129, 98, 46, 14);
		panelPartidaDificil.add(lblY_2);
		
		textField_7 = new JTextField();
		textField_7.setBounds(33, 126, 86, 20);
		panelPartidaDificil.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblValor_2 = new JLabel("valor");
		lblValor_2.setBounds(129, 129, 46, 14);
		panelPartidaDificil.add(lblValor_2);
		
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(282, 29, 127, 165);
		panelPartidaDificil.add(textArea_2);
		
		JButton btnFazerJogada_2 = new JButton("Fazer jogada");   //BOTAO FAZER JOGADA PARTIDA DIFICIL
		btnFazerJogada_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int x, y, valor;
					x = Integer.parseInt(textField_2.getText());
					y = Integer.parseInt(textField_6.getText());
					valor = Integer.parseInt(textField_7.getText());
					partida.executaMovimento(x, y, valor);
					JOptionPane.showMessageDialog(null, "Jogada feita!");
					String s = "";
					for(int i = 0; i < 9; i++){
						for(int j = 0; j < 9; j++){
							s +=tabuleiro.getGrid()[i][j];
							s +=" ";
						}
						s +="\n";
					}
					textArea_2.setText(s);										
				} catch (MovimentoInvalidoException a) {
					JOptionPane.showMessageDialog(null, "Movimento invalido!");
				}catch(MovimentoIncorretoException i){
					JOptionPane.showMessageDialog(null, "Movimento incorreto!");
				}catch(Exception o){
					JOptionPane.showMessageDialog(null, "Movimento invalido!");
				}
				String q = "";
				partida.setTempoFinal(System.currentTimeMillis());
				partida.setTempo();
				q += partida.getTempo();
				textField_16.setText(q);
				String p = "";
				p += partida.getQuantidadeErros();
				textField_8.setText(p);
				if(partida.isFimDeJogo() == true){
					String w = "Voce perdeu " + partida.getJogador().getNome() + " =/\n";
					for(int i = 0; i < 9; i++){
						for(int j = 0; j < 9; j++){
							w +=tabuleiro.getGabarito()[i][j];
							w +=" ";
						}
						w +="\n";
					}
					JOptionPane.showMessageDialog(null, w);
					panelPartidaDificil.setVisible(false);
					panelMenu.setVisible(true);
				}
				if(tabuleiro.isTabuleiroPreenchido() == true){
					CalculaScoreComIdade score = new CalculaScoreComIdade();
					partida.setTempoFinal(System.currentTimeMillis());
					partida.setTempo();
					score.Calcula(partida);
					String b = "Parabens " + partida.getJogador().getNome() +"! Voce venceu!\n" + "Seu score foi de " + score.getScore();
					JOptionPane.showMessageDialog(null, b);
					panelPartidaDificil.setVisible(false);
					panelMenu.setVisible(true);
				}
			}
		});
		btnFazerJogada_2.setBounds(33, 157, 107, 23);
		panelPartidaDificil.add(btnFazerJogada_2);
		
		JButton btnPedirAjuda = new JButton("Pedir ajuda");   //BOTAO PEDIR AJUDA PARTIDA DIFICIL
		btnPedirAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					partida.pedirAjuda();
					String s = "";
					for(int i = 0; i < 9; i++){
						for(int j = 0; j < 9; j++){
							s +=tabuleiro.getGrid()[i][j];
							s +=" ";
						}
						s +="\n";
					}
					textArea_2.setText(s);					
				}catch(SemAjudaException a){
					JOptionPane.showMessageDialog(null, "Voce nao tem mais pedidos de ajuda");
				}
				String q = "";
				partida.setTempoFinal(System.currentTimeMillis());
				partida.setTempo();
				q += partida.getTempo();
				textField_16.setText(q);				
				if(tabuleiro.isTabuleiroPreenchido() == true){
					CalculaScoreComIdade score = new CalculaScoreComIdade();
					partida.setTempoFinal(System.currentTimeMillis());
					partida.setTempo();
					score.Calcula(partida);
					String b = "Parabens " + partida.getJogador().getNome() +"! Voce venceu!\n" + "Seu score foi de " + score.getScore();
					JOptionPane.showMessageDialog(null, b);
					panelPartidaDificil.setVisible(false);
					panelMenu.setVisible(true);
				}
			}
		});
		btnPedirAjuda.setBounds(33, 191, 107, 23);
		panelPartidaDificil.add(btnPedirAjuda);
		
		JLabel lblErros = new JLabel("Erros");
		lblErros.setBounds(33, 225, 46, 14);
		panelPartidaDificil.add(lblErros);
		
		textField_8 = new JTextField();
		textField_8.setBounds(89, 225, 86, 20);
		panelPartidaDificil.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblTempoDecorrido_2 = new JLabel("Tempo decorrido");
		lblTempoDecorrido_2.setBounds(210, 225, 95, 14);
		panelPartidaDificil.add(lblTempoDecorrido_2);
		
		textField_16 = new JTextField();
		textField_16.setBounds(304, 222, 86, 20);
		panelPartidaDificil.add(textField_16);
		textField_16.setColumns(10);
		
		JButton btnJogar = new JButton("Jogar");    //BOTAO JOGAR
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCriacaoJogo.setVisible(true);
				panelMenu.setVisible(false);
			}
		});
		btnJogar.setBounds(165, 106, 89, 23);
		panelMenu.add(btnJogar);
		
		JButton btnSair = new JButton("Sair");     //BOTAO SAIR
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(165, 151, 89, 23);
		panelMenu.add(btnSair);
		
		JButton btnFcil = new JButton("F\u00E1cil");   //BOTAO COMEÇAR PARTIDA FACIL
		btnFcil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					nome = textField.getText();
					idade = Integer.parseInt(textField_1.getText());
					Jogador jogador = new Jogador(idade, nome);
					panelCriacaoJogo.setVisible(false);
					panelPartidaFacil.setVisible(true);
					tabuleiro = new Tabuleiro();
					partida = new Partida(jogador, tabuleiro, DificuldadePartida.FACIL);
					partida.iniciaPartida();
					String s = "";
					for(int i = 0; i < 9; i++){
						for(int j = 0; j < 9; j++){
							s +=tabuleiro.getGrid()[i][j];
							s +=" ";
						}
						s +="\n";
					}
					textArea_1.setText(s);
					String p = "";
					p += partida.getQuantidadeErros();
					textField_10.setText(p);
					String q = "";
					partida.setTempoFinal(System.currentTimeMillis());
					partida.setTempo();
					q += partida.getTempo();
					textField_14.setText(q);
					
				}catch(Exception a){
					JOptionPane.showMessageDialog(null, "Informação inválida!");
				}
			}
		});
		btnFcil.setBounds(47, 186, 89, 23);
		panelCriacaoJogo.add(btnFcil);
		
		btnDesistir.addActionListener(new ActionListener() {    //BOTAO DESISTIR PARTIDA FACIL
			public void actionPerformed(ActionEvent arg0) {
				
				String s = "";
				for(int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
						s +=tabuleiro.getGabarito()[i][j];
						s +=" ";
					}
					s +="\n";
				}
				JOptionPane.showMessageDialog(null, s);
				panelPartidaFacil.setVisible(false);
				panelMenu.setVisible(true);				
			}
		});
		
		btnNormal.addActionListener(new ActionListener() {     //BOTAO COMEÇAR PARTIDA NORMAL
			public void actionPerformed(ActionEvent e) {
				try{
					nome = textField.getText();
					idade = Integer.parseInt(textField_1.getText());
					Jogador jogador = new Jogador(idade, nome);
					panelCriacaoJogo.setVisible(false);
					panelPartidaNormal.setVisible(true);
					tabuleiro = new Tabuleiro();
					partida = new Partida(jogador, tabuleiro, DificuldadePartida.NORMAL);
					partida.iniciaPartida();
					String s = "";
					for(int i = 0; i < 9; i++){
						for(int j = 0; j < 9; j++){
							s +=tabuleiro.getGrid()[i][j];
							s +=" ";
						}
						s +="\n";
					}
					textArea.setText(s);
					String p = "";
					p += partida.getQuantidadeErros();
					textField_9.setText(p);
					String q = "";
					partida.setTempoFinal(System.currentTimeMillis());
					partida.setTempo();
					q += partida.getTempo();
					textField_15.setText(q);
				}catch(Exception a){
					JOptionPane.showMessageDialog(null, "Informação inválida!");
				}
			}
		});
		
		JButton btnDifcil = new JButton("Dif\u00EDcil");   //BOTAO COMEÇAR PARTIDA DIFICIL
		btnDifcil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					nome = textField.getText();
					idade = Integer.parseInt(textField_1.getText());
					Jogador jogador = new Jogador(idade, nome);
					panelCriacaoJogo.setVisible(false);
					panelPartidaDificil.setVisible(true);
					tabuleiro = new Tabuleiro();
					partida = new Partida(jogador, tabuleiro, DificuldadePartida.DIFICIL);
					partida.iniciaPartida();
					String s = "";
					for(int i = 0; i < 9; i++){
						for(int j = 0; j < 9; j++){
							s +=tabuleiro.getGrid()[i][j];
							s +=" ";
						}
						s +="\n";
					}
					textArea_2.setText(s);					
					String p = "";
					p += partida.getQuantidadeErros();
					textField_8.setText(p);
					String q = "";
					partida.setTempoFinal(System.currentTimeMillis());
					partida.setTempo();
					q += partida.getTempo();
					textField_16.setText(q);
				}catch(Exception a){
					JOptionPane.showMessageDialog(null, "Informação inválida!");
				}
			}
		});
		btnDifcil.setBounds(287, 186, 89, 23);
		panelCriacaoJogo.add(btnDifcil);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCriacaoJogo.setVisible(false);
				panelMenu.setVisible(true);
			}
		});
		btnVoltar.setBounds(168, 227, 89, 23);
		panelCriacaoJogo.add(btnVoltar);
	}
}
