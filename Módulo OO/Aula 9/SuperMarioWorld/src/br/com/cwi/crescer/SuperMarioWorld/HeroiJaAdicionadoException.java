package br.com.cwi.crescer.SuperMarioWorld;

public class HeroiJaAdicionadoException extends Exception {

    public HeroiJaAdicionadoException() {
        super("Já contém um herói na fase, não poderá adicionar outro");
    }
}
