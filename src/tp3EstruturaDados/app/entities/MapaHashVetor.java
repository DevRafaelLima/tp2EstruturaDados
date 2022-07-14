public class MapaHashVetor {
    private Veiculo[] vetor;
    
    public MapaHashVetor() {
        this.vetor = new Veiculo[20];
    }
    
    private int hash(int chave) {
        return chave % this.vetor.length;
    }
    
    public Veiculo get(int chave) {
        int hash = hash(chave);
        return this.vetor[hash];
    }
    
    public void put(int chave, Veiculo valor) {
        int hash = hash(chave);
        this.vetor[hash] = valor;
    }
    
    public Veiculo remove(int chave) {
        int hash = hash(chave);
        Veiculo veiculo = this.vetor[hash];
        this.vetor[hash(chave)] = null;
        return veiculo;
    }
        
    
}