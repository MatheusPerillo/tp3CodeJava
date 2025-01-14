package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.ControleBebida;

import controle.ControleCliente;
import controle.ControleDados;
import controle.ControleFuncionario;
import controle.ControlePastel;
import modelo.Bebida;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Pastel;
import modelo.Pedido;
import modelo.Produto;
/**
 * Classe para exibir a tela de pedir produto que cont�m os atributos e os elementos da interface gr�fica 
 * @author Joao Victor Correia
 * @author Matheus Perillo 
 * @version 1.0(out,2021)
 *
 */
public class TelaPedidoProduto implements ActionListener {
	private JFrame janela;
	private  JLabel labelPastel = new JLabel("Escolha seu pastel:");
	private JComboBox<String> pasteis;
	private  JLabel labelBebida = new JLabel("Escolha sua bebida:");
	private JComboBox<String> bebidas;
	
	private  JLabel labelQtd = new JLabel("Digite a quantidade:");
	private  JTextField valorQtd = new JTextField(3);
	private  JButton confirmar = new JButton("Confirmar");
	private String s;
	private int op;
	private ControleDados dados;
	/**
	 * M�todo para exibir elementos da interface gr�fica e possibilitar pedido de produtos
	 * @param op	int para verificar qual opera��o ser� realizada <br>
	 * 1- Pedir Pastel <br>
	 * 2- Pedir Bebida <br>
	 
	 * @param d	dados presentes no sistema
	
	 */
	public void fazerPedido(ControleDados d, int op) {
		this.op = op;
		this.dados = d;
		String[] listaPasteis = new ControlePastel(dados).getNomePasteis();
		String[] listaBebidas = new ControleBebida(dados).getNomeBebidas();
		
		pasteis = new JComboBox<String>(listaPasteis);
		bebidas = new JComboBox<String>(listaBebidas);
		

		if (op == 1)
			s = "Pedir pastel";

		if (op == 2)
			s = "Pedir bebida";

		janela = new JFrame(s);
		
		labelPastel.setBounds(30, 20, 150, 25);
		pasteis.setBounds(230, 20, 180, 25);
		labelBebida.setBounds(30, 20, 150, 25);
		bebidas.setBounds(230, 20, 180, 25);
		labelQtd.setBounds(30, 50, 150, 25);
		valorQtd.setBounds(230, 50, 28, 25);
		
		confirmar.setBounds(170, 100, 100, 30);

		this.janela.setSize(450, 200);
		this.janela.setLayout(null);
		this.janela.setVisible(true);

		this.janela.add(labelQtd);
		this.janela.add(valorQtd);
		
		this.janela.add(confirmar);

		if (op == 1) {
			this.janela.add(labelPastel);
			this.janela.add(pasteis);
		}
		if (op == 2) {
			this.janela.add(labelBebida);
			this.janela.add(bebidas);
		}

		confirmar.addActionListener(this);
	}
	/** 
	 * M�todo para realizar uma a��o quando ocorre um evento: 
	 *<br>
	 * A��o-  realizar pedido de acordo com a opera��o passada na fun��o cadastrarEditar     
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == confirmar) {
			try {
				int quantidade = Integer.valueOf(valorQtd.getText());
				
				if (op == 1) {
					String nome =  (String) pasteis.getSelectedItem();
					Pastel p = new ControlePastel(dados).buscarPorNome(nome);
					dados.getPedido().pedirPastel(p, quantidade);
					mensagemSucessoPedido(1, p);
				}
				if (op == 2) {
					String nome = (String) bebidas.getSelectedItem();
					Bebida b =  new ControleBebida(dados).buscarPorNome(nome);
					dados.getPedido().pedirBebida(b, quantidade);
					mensagemSucessoPedido(1, b);
				}
				
				
				
			} catch (StringIndexOutOfBoundsException exc1) {
				mensagemSemEstoque();
			} catch (NumberFormatException exc2) {
				mensagemErro();
			}
		}

	}
	/**
	 * M�todo para exibir uma mensagem de sucesso ao pedir produtos
	 * @param op	int para verificar qual opera��o ser� realizada <br>
	 * 1- Pedir Pastel <br>
	 * 2- Pedir Bebida <br>
	 * @param p - Produto pedido
	 */
	public void mensagemSucessoPedido(int op,Produto p) {
		if (op == 1) {
			JOptionPane.showMessageDialog(null, "Pastel pedido com sucesso!\n" + p , null, JOptionPane.INFORMATION_MESSAGE);
			janela.dispose();
		}
		if (op == 2) {
			JOptionPane.showMessageDialog(null, "Bebida pedida com sucesso!\n" + p, null, JOptionPane.INFORMATION_MESSAGE);
			janela.dispose();
		}
	}
	/**
	 * M�todo para exibir uma mensagem de erro ao pedir produto<br>
	 * Poss�veis erros: <br>
	 * 1- Foi digitado valores n�o num�ricos no campo quantidade; <br>
	
	 */
	public void mensagemErro() {

		JOptionPane.showMessageDialog(null, "Digite apenas n�meros na quantidade", null, JOptionPane.ERROR_MESSAGE);
		janela.dispose();

	}
	/**
	 * M�todo para exibir uma mensagem de erro ao pedir um produto com a quantidade em estoque menor do que a digitada<br>
	
	
	 */
	public void mensagemSemEstoque() {

		JOptionPane.showMessageDialog(null,
				"N�o temos essa quantidade em estoque;\n" + "Por favor pe�a uma quatidade menor ou outro pastel;\n" + "Fa�a a reposi��o do estoque;", null,
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();

	}

}
