package br.com.cwi.crescer.SuperMarioWorld;

public class SuperComputadorQueSabeJogarMario {

    CriadorDeMapa mapa;

    public boolean executarSimulacao(CriadorDeMapa mapa) throws NaoEPossivelCompletarAFase {
        mapa.percorrerMapa();
        if (mapa.getMapa()[mapa.getMapa().length - 1] == null || (mapa.getMapa()[mapa.getMapa().length - 1].getNomeNoMapa() != "M" && mapa.getMapa()[mapa.getMapa().length - 1].getNomeNoMapa() != "L")) {
            return false;
        } else {
            return true;
        }
    }
}