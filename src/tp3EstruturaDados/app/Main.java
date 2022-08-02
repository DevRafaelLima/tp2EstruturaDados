package tp3EstruturaDados.app;

import tp3EstruturaDados.app.entities.Veiculo;
import tp3EstruturaDados.app.estruturaDeDados.AB;
import tp3EstruturaDados.app.estruturaDeDados.TAD;

public class Main {
	private static void popula() {
		TAD tad = new TAD();
		AB ab = new AB();

		int aux = 0;
		while(aux < 250) {
			Veiculo veiculo = new Veiculo();
			ab.recursiveAdd(veiculo);
			aux++;
		}
		System.out.println(ab.size());
	}

	public static void main(String[] args) {
		popula();
	}

}
