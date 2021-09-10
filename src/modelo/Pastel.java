package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import helper.Util;

public class Pastel extends Produto {

	private String tamanho;
	private String sabor;

	public Pastel(String nome, Double valor, String descricao, int qtdEstoque, String tamanho, String sabor) {
		super(nome, valor, descricao, qtdEstoque);
		this.tamanho = tamanho;
		this.sabor = sabor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	@Override
	public String toString() {
		return "\nNome: " + this.getNome() + "\nSabor: " + this.getSabor() + "\nTamanho: " + this.getTamanho()
				+ "\nDescri��o: " + this.getDescricao() + "\nValor: " + Util.doubleParaString(this.getValor())
				+ "\nQuantidade Em estoque: " + this.getQtdEstoque();
	}

	
	public static Pastel buscarPorNome(HashMap <Pastel,Integer> lista) {
		System.out.println("\nDigite o nome do Pastel");
		String nome= Main.ler.nextLine();
		try {
			 Optional<Pastel> x = lista.keySet().stream()
					.filter(p -> p.getNome().toUpperCase().equals(nome.toUpperCase())).findFirst();
			return x.get();
		} catch (Exception e) {
			System.out.println("Pastel n�o encontrado");
		}
		return null;
	}
	
	public static Pastel buscarPorNome(ArrayList<Pastel> lista) {
		System.out.println("\nDigite o Nome do pastel");
		String nome= Main.ler.nextLine();
		try {
			 for(Pastel p: lista) {
				 if(p.getNome().toUpperCase().equals(nome.toUpperCase())) {
					 return p;
				 }
			 }
		} catch (Exception e) {
			System.out.println("Pastel n�o encontrado");
		}
		return null;
	}
	
	public static void cadastrar(List<Pastel> lista) {
		System.out.println("Informe o Nome: ");
		String nome = Main.ler.nextLine();

		System.out.println("Informe o Sabor: ");
		String sabor = Main.ler.nextLine();

		System.out.println("Informe o Tamanho: ");
		String tamanho = Main.ler.nextLine();

		System.out.println("Informe a Descri��o: ");
		String descricao = Main.ler.nextLine();

		System.out.println("Informe o Valor: ");
		Double valor = Main.ler.nextDouble();
		Main.ler.nextLine();

		System.out.println("Informe o Estoque: ");
		int qtdEstoque = Main.ler.nextInt();
		Main.ler.nextLine();
		Pastel p = new Pastel( nome,  valor,  descricao, qtdEstoque,  tamanho,sabor);
		lista.add(p);
	}
	
	public static void remover(List<Pastel> lista) {
		Pastel p = Pastel.buscarPorNome(Main.perillao.getPasteis());
		if (p != null) {
			lista.remove(p);
			System.out.println("Pastel removido com sucesso!");
		} else {
			System.out.println("\nPastel n�o encontrado");
		}
	}
	public static void editar(Pastel pastel) {
		System.out.println("1- Editar Nome");
		System.out.println("2- Editar Sabor");
		System.out.println("3- Editar Tamanho");
		System.out.println("4- Editar Descri��o");
		System.out.println("5- Editar Valor");
		System.out.println("6- Editar Estoque");
		System.out.println("7- Editar Tudo");

		int aux = Main.ler.nextInt();
		Main.ler.nextLine();
		switch (aux) {
		case 1:
			System.out.println("Informe o Nome: ");
			String nome = Main.ler.nextLine();
			pastel.setNome(nome);
			System.out.println("Campo alterado com sucesso!");
			Util.pausar(2);
			break;

		case 2:
			System.out.println("Informe o Sabor: ");
			String sabor = Main.ler.nextLine();
			pastel.setSabor(sabor);
			System.out.println("Campo alterado com sucesso!");
			Util.pausar(2);
			break;

		case 3:
			System.out.println("Informe o Tamanho: ");
			String tamanho = Main.ler.nextLine();
			pastel.setTamanho(tamanho);
			System.out.println("Campo alterado com sucesso!");
			Util.pausar(2);
			break;

		case 4:
			System.out.println("Informe a Descri��o: ");
			String descricao = Main.ler.nextLine();
			pastel.setDescricao(descricao);
			System.out.println("Campo alterado com sucesso!");
			Util.pausar(2);
			break;

		case 5:
			System.out.println("Informe o Valor: ");
			Double valor = Main.ler.nextDouble();
			Main.ler.nextLine();
			pastel.setValor(valor);
			System.out.println("Campo alterado com sucesso!");
			Util.pausar(2);
			break;

		case 6:
			System.out.println("Informe o Estoque: ");
			int qtdEstoque = Main.ler.nextInt();
			Main.ler.nextLine();
			pastel.setQtdEstoque(qtdEstoque);
			System.out.println("Campo alterado com sucesso!");
			Util.pausar(2);
			break;

		case 7:
			System.out.println("Informe o Nome: ");
			nome = Main.ler.nextLine();

			System.out.println("Informe o Sabor: ");
			sabor = Main.ler.nextLine();

			System.out.println("Informe o Tamanho: ");
			tamanho = Main.ler.nextLine();

			System.out.println("Informe a Descri��o: ");
			descricao = Main.ler.nextLine();

			System.out.println("Informe o Valor: ");
			valor = Main.ler.nextDouble();
			Main.ler.nextLine();

			System.out.println("Informe o Estoque: ");
			qtdEstoque = Main.ler.nextInt();
			Main.ler.nextLine();

			pastel.setNome(nome);
			pastel.setSabor(sabor);
			pastel.setTamanho(tamanho);
			pastel.setDescricao(descricao);
			pastel.setValor(valor);
			pastel.setQtdEstoque(qtdEstoque);

			System.out.println("Pastel alterado com sucesso!");
			Util.pausar(2);
			break;

		default:
			System.out.println("Op��o inv�lida");
			Util.pausar(2);
			Pastel.editar(pastel);
			break;
		}

	}

}
