package tp3EstruturaDados.app.estruturaDeDados;

import java.util.HashSet;
import java.util.Set;

import tp3EstruturaDados.app.entities.Veiculo;

public class MapaHashVetor {
	private Veiculo[] vetor;
	private Set<Integer> chassis;
	private Set<Veiculo> veiculos;
	private int size;
	private double fatorDeCarga;
	
	public static final int CAPACIDADE_DEFAULT = 20;
	
	public static final double FATOR_DE_CARGA_DEFAULT = 0.75;
	
	private static final Veiculo APAGADO = new Veiculo();
	
	public MapaHashVetor() {
		this(CAPACIDADE_DEFAULT, FATOR_DE_CARGA_DEFAULT);
	}
	public MapaHashVetor(int capacidade, double fatorDeCarga) {
		this.vetor = new Veiculo[capacidade];
		this.chassis = new HashSet<Integer>();
		this.veiculos = new HashSet<Veiculo>();
		this.fatorDeCarga = fatorDeCarga;
		this.size = 0;
		
	}
	private int hash(Integer chassi) {
		return chassi % this.vetor.length;
	}
	private int hashMultiplicacao(Integer chassi) {
		double a = 0.617648934;
		double hash = chassi * a;
		hash = (hash % 1) * this.vetor.length;
		return (int)hash;
	}
	
	public Set<Integer> getKeys(){
		return this.chassis;
	}
	
	public Set<Veiculo> getValue(){
		return this.veiculos;
	}
	
	public Veiculo get(Integer chassi) {
		int sondagem = 0;
		int hash;
		while(sondagem < vetor.length) {
			hash = (hash(chassi) + sondagem) % vetor.length;
			
			if(vetor[hash] == null) {
				return null;
			}
			
			if(vetor[hash].getChassi() == chassi) {
				return vetor[hash];
			}
			
			sondagem +=1;
		}
		
		return null;
	}
	
	public void put(Integer chassi, Veiculo valor) {
		if(this.size / this.vetor.length  >= this.fatorDeCarga 
				|| this.size == this.vetor.length) {
			
			Veiculo[] novoVetor = new Veiculo[this.vetor.length * 2];
			reinicializaVetor();
			
			for(Veiculo veiculo : vetor) {
				if(veiculo != null) {
					put(novoVetor, veiculo.getChassi(), veiculo);
				}
			}
			
			put(novoVetor, valor.getChassi(), valor);
			this.vetor = novoVetor;
		} else {
			this.put(this.vetor, chassi, valor);
		}
	}
	
	private void reinicializaVetor() {
		this.size = 0;
		this.chassis = new HashSet<Integer>();
		this.veiculos = new HashSet<Veiculo>();
	}
	
	private void put(Veiculo[] vetor, Integer chassi, Veiculo valor) {
		int sondagem = 0;
		int hash;
		
		while(sondagem < vetor.length) {
			hash = (hash(chassi) + sondagem) % vetor.length;
			Veiculo tmpVeiculo = vetor[hash];
			if(tmpVeiculo == null ||
					tmpVeiculo.getChassi() == chassi) {
				vetor[hash] = valor;
				this.chassis.add(chassi);
				this.veiculos.add(valor);
				this.size += 1;
				return;
			}
			sondagem += 1;
		}
	}
	
	public Veiculo remove(int chassi) {
		int sondagem = 0;
		int hash;
		while(sondagem < vetor.length) {
			hash = (hash(chassi) + sondagem) % vetor.length;
			
			if(vetor[hash] != null && vetor[hash].getChassi() == chassi) {
				Veiculo veiculo = vetor[hash];
				this.chassis.remove(chassi);
				this.veiculos.remove(veiculo);
				this.size -=1;
				return veiculo;
			}
			
			sondagem+=1;
		}
		
		return null;
	}
	
	public int size() {
		return this.size;
	}
	public void ordenaChassi() {
		for(int i = 0; i < this.size; i++) {
			int menor = i;
			//verifico se não é null
			if(vetor[i]!= null) {
				for(int j = 1+i; j < this.size; j++) {
					if(vetor[j]!= null) {
						if(this.vetor[j].getChassi() < this.vetor[i].getChassi()) {
							menor = j;
						}						
					}
				}
				
			}
			Veiculo aux = vetor[i];
			this.vetor[i] = this.vetor[menor];
			this.vetor[menor] = aux;
		}
	}
	public void impressaoFord() {
		for(int i = 0; i < this.size; i++) {
			if(this.vetor[i] != null) {
				if(vetor[i].getMarca().equals("Ford")) {
					System.out.println(this.vetor[i].toString());									
				}
			}
		}
	}
	public void impressao() {
		for(int i = 0; i < this.size; i++) {
			if(this.vetor[i] != null) {
				
					System.out.println(this.vetor[i].toString());									
				
			}
		}
	}
	public void removeChassis() {
		for(int i = 0; i < this.size; i++) {
			if(this.vetor[i] != null) {
				if(vetor[i].getChassi() < 202050000) {
					System.out.println(remove(vetor[i].getChassi()));
				}				
			}
		}
	}

}
