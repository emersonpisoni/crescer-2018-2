package br.com.cwi.crescer.doom;

public abstract class Arma {

    protected int dano;

    public Arma(int dano) {
        this.dano = dano;
    }

    public void atirar(Demonio demonio) {
        demonio.receberDano(dano);
    }

    public abstract void animacaoDoTiro();
}
