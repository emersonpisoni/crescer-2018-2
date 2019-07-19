package br.com.cwi.crescer.Desafio.Item.Armas;

import br.com.cwi.crescer.Desafio.Item.Item;

public class Bazuca extends Item {

    private static final String[][] ESPACO_BAZUCA = new String[4][10];
    private static final int PESO_BAZUCA = 2;
    private static final String NOME_BAZUCA = " Tres8ao ";
    private static final int ESPACO_TOTAL_BAZUCA = 40;
    private static final int LINHAS_BAZUCABAZUCA = 4;
    private static final int COLUNAS_BAZUCABAZUCA = 10;

    public Bazuca() {
        super(PESO_BAZUCA, NOME_BAZUCA, ESPACO_BAZUCA, ESPACO_TOTAL_BAZUCA, LINHAS_BAZUCABAZUCA, COLUNAS_BAZUCABAZUCA);
    }
}
