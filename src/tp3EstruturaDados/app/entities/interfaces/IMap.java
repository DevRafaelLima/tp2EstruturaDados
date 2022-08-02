package tp3EstruturaDados.app.entities.interfaces;

import tp3EstruturaDados.app.entities.Veiculo;

public interface IMap {
	int size();
	boolean isEmpty();
	boolean containsKey(Veiculo key);
	boolean containsValue(Object value);
	Veiculo get(Object key);
	Veiculo put(int key, Veiculo value);
	void removeVeiculos();
}
