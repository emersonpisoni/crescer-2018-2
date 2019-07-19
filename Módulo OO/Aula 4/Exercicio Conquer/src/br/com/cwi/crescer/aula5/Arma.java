package br.com.cwi.crescer.aula5;

public abstract class Arma {

    protected String nomeDaArma;
    protected int danoDaArma;

    public Arma(String nomeDaArma, int dano){
        this.nomeDaArma = nomeDaArma;
        this.danoDaArma = dano;
    }

    public int getDanoDaArma() {
        return danoDaArma;
    }

    public abstract void atacarCastelo(Castelo castelo);
}