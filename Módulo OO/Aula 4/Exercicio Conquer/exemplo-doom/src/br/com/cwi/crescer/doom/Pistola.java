package br.com.cwi.crescer.doom;

public class Pistola extends Arma {

    private static final int DANO_PISTOLA = 10;

    public Pistola() {
        super(DANO_PISTOLA);
    }

    @Override
    public void animacaoDoTiro() {
        // puft
    }
}
