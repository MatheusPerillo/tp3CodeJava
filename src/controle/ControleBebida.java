package controle;

import java.util.ArrayList;

import modelo.Bebida;

public class ControleBebida {
	private ArrayList<Bebida> c;
	
	public ControleBebida(ControleDados d) {
		c = d.getBebidas();
		}
	
	public String[] getNomeBebidas() {
		String [] s = new String[this.c.size()];
		for (int i = 0; i < this.c.size(); i++) {
			s[i] = c.get(i).getNome();
		}
		return s;
	}
}
