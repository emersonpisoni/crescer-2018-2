package br.com.cwi.crescer.SuperMarioWorld;

public class PosicaoOcupadaException extends Exception {

    public PosicaoOcupadaException() {
        super("Você não pode adicionar nessa posição, Lugar já tem um elemento");
    }
}
