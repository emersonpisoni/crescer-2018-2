package br.com.cwi.crescer.aula5;

public class Ariete extends Arma {

    public Ariete(String nomeDaArma, int dano) {
        super(nomeDaArma, dano);
    }

    @Override
    public void atacarCastelo(Castelo castelo) {
        castelo.receberDanoDosArietes(this.getDanoDaArma());
    }

}