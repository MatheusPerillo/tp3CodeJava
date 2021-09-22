package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaMenu implements ActionListener {
	
	private static JFrame janela = new JFrame("Controle de Curso");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton cliente = new JButton("Cliente");
	private static JButton funcionario = new JButton("Funcion�rio");
	private static JButton vendas = new JButton("Vendas");
	private static JButton pastel = new JButton("Pastel");
	private static JButton bebida = new JButton("Bebida");
	private static JButton loja = new JButton("Loja");

	
	public TelaMenu() {
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(150, 30, 150, 30);
		cliente.setBounds(120, 100, 100, 30);
		funcionario.setBounds(120, 150, 100, 30);
		vendas.setBounds(120, 200, 100, 30);
		pastel.setBounds(240, 100, 100, 30);
		bebida.setBounds(240, 150, 100, 30);
		loja.setBounds(240, 200, 100, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(cliente);
		janela.add(funcionario);
		janela.add(vendas);
		janela.add(pastel);
		janela.add(bebida);
		janela.add(loja);
		
		janela.setSize(500, 300);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		TelaMenu menu = new TelaMenu();
		
		cliente.addActionListener(menu);
		funcionario.addActionListener(menu);
		vendas.addActionListener(menu);
		pastel.addActionListener(menu);
		bebida.addActionListener(menu);
		loja.addActionListener(menu);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == aluno)
			//new TelaPessoa().mostrarDados(dados, 1);
		
		if(src == prof)
			//new TelaPessoa().mostrarDados(dados, 2);
		
		if(src == curso)
			JOptionPane.showMessageDialog(null, 
					"Ainda precisam ser implementadas as funcionalidades\n"
					+ "relacionadas a curso e a matr�cula", null, 
					JOptionPane.INFORMATION_MESSAGE);
	}
}
