package tp3EstruturaDados.app;

import tp3EstruturaDados.app.entities.Veiculo;
import tp3EstruturaDados.app.estruturaDeDados.TAD;

public class Main {
	private static void popula() {
		//TAD
		TAD tad = new TAD();
		
		int aux = 0;
		while(aux < 100000) {
			//veiculo
			Veiculo veiculo = new Veiculo();
			tad.add(veiculo);
			aux++;
		}
		tad.impressao();
	}
	public static void main(String[] args) {
		popula();
	}

}
