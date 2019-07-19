package br.com.cwi.crescer.aula5;

public class Catapulta extends Arma{

    public Catapulta(String nomeDaArma, int dano, int alturaDoAtaque) {
        super(nomeDaArma, dano+(alturaDoAtaque*2));
    }

    @Override
    public void atacarCastelo(Castelo castelo) {
        castelo.receberDanoDaCatapulta(getDanoDaArma());
    }

}
