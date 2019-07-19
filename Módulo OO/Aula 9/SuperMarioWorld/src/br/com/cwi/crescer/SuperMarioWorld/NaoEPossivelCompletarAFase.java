package br.com.cwi.crescer.SuperMarioWorld;

public class NaoEPossivelCompletarAFase extends Exception {

    public NaoEPossivelCompletarAFase() {
        super("Heroi nao consegue chegar no final da fase");
    }
}
