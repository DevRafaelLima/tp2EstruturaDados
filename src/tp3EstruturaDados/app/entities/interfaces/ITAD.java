package tp3EstruturaDados.app.entities.interfaces;

import tp3EstruturaDados.app.entities.Veiculo;

public interface ITAD {
	 public int tamanho();
	 public void add(Veiculo veiculo);
	 public boolean contem(Veiculo veiculo);
	 public boolean remove(Veiculo veiculo);
	 public void garanteEspaco();
	 public boolean cheio();
}
