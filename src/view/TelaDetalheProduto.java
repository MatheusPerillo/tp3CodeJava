package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controle.*;
import modelo.Pastel;
import modelo.Bebida;
import modelo.Produto;

public class TelaDetalheProduto implements ActionListener {

	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelSabor = new JLabel("Sabor: ");
	private JTextField valorSabor;
	private JLabel labelTipo = new JLabel("Tipo: ");
	private JComboBox <String> valorTipo;
	private JLabel labelVolume = new JLabel("Volume: ");
	private JTextField valorVolume;
	private JLabel labelTamanho = new JLabel("Tamanho: ");
	private JComboBox <String> valorTamanho;
	private JLabel labelDescricao = new JLabel("Descri��o: ");
	private JTextField valorDescricao;
	private JLabel labelPreco = new JLabel("Valor: ");
	private JTextField valorPreco;
	private JLabel labelEstoque = new JLabel("Em estoque: ");
	private JTextField valorEstoque;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;

	public void cadastrarEditar(int op, ControleDados d, int pos) {
		opcao = op;
		posicao = pos;
		dados = d;

		String[] tamanhos = {"P","M","G", "GG"};
		String[] tipos = {"garrafa","copo","garapa", "vidro"};
		
		if (op == 1)
			s = "Cadastro de Pastel";
		if (op == 2)
			s = "Cadastro de Bebida";
		if (op == 3)
			s = "Detalhe de Pastel";
		if (op == 4)
			s = "Detalhe de Bebida";

		janela = new JFrame(s);

		// Preenche dados com dados do pastel que foi clicado
		if (op == 3) {
			valorNome = new JTextField(dados.getPasteis().get(pos).getNome(), 200);
			valorSabor = new JTextField(dados.getPasteis().get(pos).getSabor(), 100);
			valorTamanho = new JComboBox <String> (tamanhos);
			valorTamanho.setSelectedItem(dados.getPasteis().get(pos).getTamanho());
			valorDescricao = new JTextField(dados.getPasteis().get(pos).getDescricao(), 200);
			valorPreco = new JTextField(String.valueOf(dados.getPasteis().get(pos).getValor()), 50);
			valorEstoque = new JTextField(String.valueOf(dados.getPasteis().get(pos).getQtdEstoque()), 9);
			valorTipo = new JComboBox <String> (tipos);
			valorTipo.setSelectedItem(dados.getBebidas().get(pos).getTipo());
			valorVolume = new JTextField(5);
			
			// Preenche dados com dados da bebida que foi clicada
		} else if (op == 4) {
			valorNome = new JTextField(dados.getBebidas().get(pos).getNome(), 200);
			valorTipo = new JComboBox <String> (tipos);
			valorVolume = new JTextField(String.valueOf(dados.getBebidas().get(pos).getVolume()), 5);
			valorDescricao = new JTextField(dados.getBebidas().get(pos).getDescricao(), 200);
			valorPreco = new JTextField(String.valueOf(dados.getBebidas().get(pos).getValor()), 50);
			valorEstoque = new JTextField(String.valueOf(dados.getBebidas().get(pos).getQtdEstoque()), 9);
			valorSabor = new JTextField(100);
			valorTamanho = new JComboBox <String> (tamanhos);

			// N�o preenche com dados
		} else {

			valorNome = new JTextField(200);
			valorSabor = new JTextField(100);
			valorTamanho = new JComboBox <String> (tamanhos);
			valorDescricao = new JTextField(200);
			valorPreco = new JTextField(50);
			valorEstoque = new JTextField(9);
			valorTipo = new JComboBox <String> (tipos);
			valorVolume = new JTextField(5);

			if (op == 1) {
				botaoSalvar.setBounds(125, 220, 115, 30);
			} else if (op == 2) {
				botaoSalvar.setBounds(125, 220, 115, 30);
			}

		}

		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(110, 20, 180, 25);

		labelDescricao.setBounds(30, 50, 150, 25);
		valorDescricao.setBounds(110, 50, 180, 25);

		labelSabor.setBounds(30, 80, 150, 25);
		valorSabor.setBounds(110, 80, 180, 25);

		labelTamanho.setBounds(30, 110, 150, 25);
		valorTamanho.setBounds(110, 110, 180, 25);

		labelTipo.setBounds(30, 80, 150, 25);
		valorTipo.setBounds(110, 80, 180, 25);

		labelVolume.setBounds(30, 110, 150, 25);
		valorVolume.setBounds(110, 110, 180, 25);

		labelPreco.setBounds(30, 140, 150, 25);
		valorPreco.setBounds(110, 140, 180, 25);

		labelEstoque.setBounds(30, 170, 150, 25);
		valorEstoque.setBounds(110, 170, 27, 25);

		// Coloca os campos relacionados a pastel
		if (op == 1 || op == 3) {
			this.janela.add(labelTamanho);
			this.janela.add(valorTamanho);
			this.janela.add(labelSabor);
			this.janela.add(valorSabor);

		}

		// Coloca campos exclusivos de bebida
		if (op == 2 || op == 4) {
			this.janela.add(labelVolume);
			this.janela.add(valorVolume);
			this.janela.add(labelTipo);
			this.janela.add(valorTipo);
		}
			// Coloca botoes de excluir e salvar
			if (op == 3) {
				botaoSalvar.setBounds(60, 217, 115, 30);
				botaoExcluir.setBounds(190, 217, 115, 30);
				this.janela.add(botaoExcluir);
			} else if (op == 4) {
				botaoSalvar.setBounds(60, 217, 115, 30);
				botaoExcluir.setBounds(190, 217, 115, 30);
				this.janela.add(botaoExcluir);
			}
		

		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelPreco);
		this.janela.add(valorPreco);
		this.janela.add(labelDescricao);
		this.janela.add(valorDescricao);
		this.janela.add(labelEstoque);
		this.janela.add(valorEstoque);
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		if (op == 2 || op == 4) {
			this.janela.setSize(380, 310);
		} else if (op == 1 || op == 3) {
			this.janela.setSize(380, 310);
		}
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == botaoSalvar) {
			try {
				boolean res = false;

				String nome = valorNome.getText();
				String descricao = valorDescricao.getText();
				double preco = Double.valueOf(valorPreco.getText());
				int estoque = Integer.valueOf(valorEstoque.getText());
				
				// inserir e editar Pastel
				if(opcao == 1) {
					 String sabor = valorSabor.getText();
					 String tamanho = (String) valorTamanho.getSelectedItem();
					 Pastel p = new Pastel(nome, preco, descricao, estoque, tamanho, sabor);
					 res = dados.inserirPastel(p);
					 
				}else if(opcao == 3) {
					 String sabor = valorSabor.getText();
					 String tamanho = (String) valorTamanho.getSelectedItem();
					 Pastel p = new Pastel(nome, preco, descricao, estoque, tamanho, sabor);
					 res = dados.editarPastel(posicao, p);
				}
					
				// inserir e editar Bebida
				
				if (opcao == 2) {
					 String tipo = (String) valorTipo.getSelectedItem();
					 int volume = Integer.valueOf(valorVolume.getText());
					 Bebida b = new Bebida(nome, preco, descricao, estoque, volume, tipo);
					 res = dados.inserirBebida(b);
					 
				}else if(opcao == 4) {
					 String tipo = (String) valorTipo.getSelectedItem();
					 int volume = Integer.valueOf(valorVolume.getText());
					 Bebida b = new Bebida(nome, preco, descricao, estoque, volume, tipo);
					 res = dados.editarBebida(posicao, b);
				}
					
					if(res) {
						mensagemSucessoCadastro();
					} else
						mensagemErroCadastro();

			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}
		}

		if (src == botaoExcluir) {
			boolean res = false;

			if (opcao == 3) {// exclui pastel
				res = dados.removerPastel(posicao);
				if (res)
					mensagemSucessoExclusao();
				else
					mensagemErroExclusao();
			}

			if (opcao == 4) { // exclui bebida
				res = dados.removerBebida(posicao);
				if (res)
					mensagemSucessoExclusao();
				else
					mensagemErroExclusao();
			}

		}

	}

	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,
				"ERRO AO SALVAR OS DADOS!\n " + "Pode ter ocorrido um dos dois erros a seguir:  \n"
						+ "1. Nem todos os campos foram preenchidos \n"
						+ "2. Volume, Valor ou  Estoque n�o cont�m apenas n�meros \n" 
						+ "3. Foi digitado uma v�rgula (,) no lugar de um ponto (.) em Valor ",
				null, JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroExclusao() {
		JOptionPane.showMessageDialog(null,
				"Ocorreu um erro ao excluir o dado.\n ",
				null, JOptionPane.ERROR_MESSAGE);
	}

}
