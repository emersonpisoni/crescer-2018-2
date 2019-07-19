package br.com.cwi.crescer.doom;

public class Doze extends Arma {

    private static final int DANO_DOZE = 50;

    public Doze() {
        super(DANO_DOZE);
    }

    public void atirar(Demonio demonio) {
        // modificar o comportamento
        dano += 10;

        // chamar a implementação padrao
        super.atirar(demonio);
    }

    @Override
    public void animacaoDoTiro() {
        // Animação do tiro
    }
}
