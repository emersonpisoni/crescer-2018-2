package br.com.cwi.crescer.doom;

public class BFG extends Arma {

    private static final int DANO_BFG = 0;

    public BFG() {
        super(DANO_BFG);
    }

    @Override
    public void atirar(Demonio demonio) {
        demonio.morrer();
    }

    @Override
    public void animacaoDoTiro() {
        // BOOOOOMMMM
    }
}
