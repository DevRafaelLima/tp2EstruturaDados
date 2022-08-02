package tp3EstruturaDados.app;

import tp3EstruturaDados.app.entities.Veiculo;
import tp3EstruturaDados.app.estruturaDeDados.MapaHashVetor;

public class Main {
	private static void popula() {
//		//TAD
//		TAD tad = new TAD();
//		
//		int aux = 0;
//		while(aux < 100000) {
//			//veiculo
//			Veiculo veiculo = new Veiculo();
//			tad.add(veiculo);
//			aux++;
//		}
//		tad.impressao();
		MapaHashVetor mhv = new MapaHashVetor();
		int aux = 0;
		while (aux < 10) {
			Veiculo veiculo = new Veiculo();
			mhv.put(veiculo.getChassi(), veiculo);	
			System.out.println(mhv.get(veiculo.getChassi()));
			aux++;
		}
		System.out.println("Ordena chassi");
		mhv.ordenaChassi();
		System.out.println("Impressão");
		mhv.impressao();
//		System.out.println("Remove chassis");
//		mhv.removeChassis();
		System.out.println("Finalizou");
	}
	public static void main(String[] args) {
		popula();
	}

}
