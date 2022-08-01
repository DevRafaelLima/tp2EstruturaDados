package tp3EstruturaDados.app;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import tp3EstruturaDados.app.entities.Veiculo;

public class MapVeiculo implements Map {
	private Veiculo[] vetor;
	
	public MapVeiculo() {
		this.vetor = new Veiculo[20];
	}
	
	private int hash(int chave) {
		return chave % this.vetor.length;
	}
	
	public Veiculo get(int chave) {
		int hash = hash(chave);
		return this.vetor[hash];
	}
		
	//public void put(int chave, Aluno valor) {
	//	int hash = hash(chave);
	//	this.vetor[hash] = valor;
	//}
	
	public Veiculo remove(int chave) {
		int hash = hash(chave);
		Veiculo veiculo = this.vetor[hash];
		this.vetor[hash(chave)] = null;
		return veiculo;
	}
	
	public void put(int chave, Veiculo valor) {
		int sondagem = 0;
		int hash;
		
		while (sondagem < vetor.length) {
			hash = (hash(chave) + sondagem) % vetor.length;
			if (vetor[hash] == null || vetor[hash].getChassi() == chave) {
				vetor[hash] = valor;
				return;
			}
			sondagem++;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object put(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
