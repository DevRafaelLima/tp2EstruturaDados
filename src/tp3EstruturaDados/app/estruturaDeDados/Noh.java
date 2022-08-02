package tp3EstruturaDados.app.estruturaDeDados;

import tp3EstruturaDados.app.entities.Veiculo;

public class Noh {
	private Veiculo noh;
	private Noh ant;
	private Noh prox;
	
	public Noh(Veiculo noh) {
		this.noh = noh;
		this.ant = null;
		this.prox = null;
	}
	
	public Veiculo getVeiculo() {
		return null;
	}
	public Noh getProx() {
		return null;
	}
	public void setProx(Noh n) {
		this.prox = n;
	}
}
