package tp3EstruturaDados.app.estruturaDeDados;

import tp3EstruturaDados.app.entities.Veiculo;
import tp3EstruturaDados.app.entities.interfaces.IMap;

public class AB implements IMap{

	private Noh raiz;
	private int tamanho;

	@Override
	public int size() {
		return this.tamanho;
	}

	@Override
	public boolean isEmpty() { //método verifica se arvore esta vazia
		return this.raiz == null;
	}

	public void recursiveAdd(Veiculo veiculo) { //método de inserção recursivo pt1
		if (this.raiz == null){
			this.raiz = new Noh(veiculo);
			tamanho++;
		}else {
			recursiveAdd(this.raiz, veiculo);
		}
	}

	private void recursiveAdd(Noh node, Veiculo veiculo) { //método de inserção recursivo pt2
		if (veiculo.getChassi() < node.valor.getChassi()) {
			if (node.esq == null) {
				Noh newNode = new Noh(veiculo);
				node.esq = newNode;
				newNode.pai = node;
				tamanho++;
				return;
		}	
			recursiveAdd(node.esq, veiculo);
		} else {
			if (node.dir == null) {
				Noh newNode = new Noh(veiculo);
				node.dir = newNode;
				newNode.pai = node;
				tamanho++;
				return;
			}
			recursiveAdd(node.dir, veiculo);
		}
	}

	@Override
	public boolean containsKey(Veiculo veiculo) { //método que busca por chassi
		isEmpty();
		Noh atual = this.raiz;  //começa a procurar desde raiz
		while (atual.valor.getChassi() != veiculo.getChassi()) { //enquanto nao encontrou
			if(veiculo.getChassi() < atual.valor.getChassi()) atual = atual.esq; //caminha para esquerda
			else atual = atual.dir; //caminha para direita
			if (atual == null) return false; //encontrou uma folha -> sai
		}
		return true; //terminou o laço while e chegou aqui é pq encontrou item	
	}

	@Override
	public void removeVeiculos() { //método que remove todos os veiculos com chassi menor que 202050000
		Noh atual2 = this.raiz;
		if(this.raiz == null) {System.out.println("A AB está vazia!");}
		while(atual2 != null){
			if(atual2.valor.getChassi() <= 202050000){
				if(atual2.dir != null && atual2.esq != null){ // se o nó tiver 2 filhos
					atual2.dir = atual2; // troca o nó com seu sucessor (aq ta pro da dir por enquanto)

					////////////// CHECAR //////////////

				}else if(atual2.dir != null && atual2.esq == null){ // se tiver 1 filho - direita
					atual2.dir.pai = atual2.pai; // ligando nó filho ao pai do nó a ser removido
					atual2 = null; //seta como null e remove???

				}else if(atual2.dir == null && atual2.esq != null){ // se tiver 1 filho - esquerda
					atual2.esq.pai = atual2.pai; // ligando nó filho ao pai do nó a ser removido
					atual2 = null; //seta como null e remove???

				}else if(atual2.dir == null && atual2.esq == null){ // se não tiver nenhum filho
					if(atual2 == this.raiz){ // verifica se o nó a ser removido é raiz
						this.raiz = null; // raiz aponta pra null
					}else if(atual2.pai != null){ // se o nó tiver pai
						atual2.pai = null; // pai do nó a ser removido aponta pra null
					}
				}
			}
		}
	}

	@Override
	public boolean containsValue(Object value) {
		return false;
	}

	@Override
	public Veiculo get(Object key) {
		return null;
	}

	@Override
	public Veiculo put(int key, Veiculo value) {
		return null;
	}

	/*public ArrayList<Object> imprime() {
			ArrayList<Integer> list = new ArrayList<Integer>();
			Deque<Noh> queue = new LinkedList<Noh>();
	
			if (!isEmpty()) {
				queue.addLast(this.raiz);
				while (!queue.isEmpty()) {
					Noh atual = queue.removeFirst();
	
					list.(atual.valor);
	
					if (atual.esq != null)
						queue.addLast(atual.esq);
					if (atual.dir != null)
						queue.addLast(atual.dir);
				}
			}
		return list;
	}*/
}

