package br.com.cwi.crescer.doom;

public class Soldado {

    private Arma arma = new BFG();

    public void atirar(Demonio demonio) {
        arma.atirar(demonio);
        arma.animacaoDoTiro();
    }

    public void equiparArma(Arma arma) {
        this.arma = arma;
    }
}
