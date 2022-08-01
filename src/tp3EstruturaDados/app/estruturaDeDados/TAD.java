package tp3EstruturaDados.app.estruturaDeDados;


import tp3EstruturaDados.app.entities.Veiculo;
import tp3EstruturaDados.app.entities.interfaces.ITAD;

public class TAD implements ITAD{
	private Veiculo[] veiculo = new Veiculo[100000];
	private int acumulador = 0;
	public void add(Veiculo veiculo) {
			if(!contem(veiculo)) {
				this.veiculo[acumulador] = veiculo;	
				acumulador++;				
			}
	}
	@Override
	public int tamanho() {
		return this.acumulador;
	}
	@Override
	public boolean contem(Veiculo veiculo) {
		for(int i =0; i< this.acumulador; i++) {
			if(veiculo.getChassi() == this.veiculo[i].getChassi()) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean remove(Veiculo veiculo) {
		int aux = -1;
		for(int i = 0; i < this.acumulador; i++) {
			if(veiculo == this.veiculo[i]) {
				aux = i;
				break;
			}
		}
		if(aux != -1) {
			for(int i = aux; i < (this.acumulador - 1); i++) {
				this.veiculo[i] = this.veiculo[i+1];
			}
			this.acumulador--;
			return true;
		}
		return false;
	}
	@Override
	public void garanteEspaco() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean cheio() {
		if(this.acumulador == this.veiculo.length)
			return true;
		return false;
	}
	public void ardenaPeloChassi() {
		
	}
	
	public void impressao() {
		for(int i = 0; i < this.acumulador; i++) {
			System.out.println(veiculo[i].toString());
		}
	}

	

}
