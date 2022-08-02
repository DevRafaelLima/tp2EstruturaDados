package tp3EstruturaDados.app.estruturaDeDados;

import tp3EstruturaDados.app.entities.Veiculo;

public class Noh{

    Veiculo valor;
    Noh esq;
    Noh dir;
    Noh pai;

    Noh(Veiculo v) {
        this.valor = v;
    }

    public Veiculo getValor() {return valor;}
    public Noh getEsq() {return esq;}
    public Noh getDir() {return dir;}
    public Noh getPai() {return pai;}
    public void setEsq(Noh n) {this.esq = esq;}
    public void setDir(Noh n) {this.dir = dir;}
    public void setPai(Noh n) {this.pai = pai;}
}
