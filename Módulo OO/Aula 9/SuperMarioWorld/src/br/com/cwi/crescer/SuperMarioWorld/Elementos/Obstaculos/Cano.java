package br.com.cwi.crescer.SuperMarioWorld.Elementos.Obstaculos;

public class Cano extends Obstaculos {

    private static final String NOME_NO_MAPA_CANO = "|";
    private int alturaDoCano;

    public Cano(int tamanhoDoCano) {
        super(NOME_NO_MAPA_CANO);
        this.alturaDoCano = tamanhoDoCano;
    }

    public int getAlturaDoCano() {
        return this.alturaDoCano;
    }


}
