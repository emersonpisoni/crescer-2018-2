package br.com.cwi.crescer.Desafio.Item.Municoes;

import br.com.cwi.crescer.Desafio.Item.Item;

public class MissilDeBazuca extends Item {

    private static final String[][] ESPACO_MUNICAO_BAZUCA = new String[2][8];
    private static final int PESO_MUNICAO_BAZUCA = 10;
    private static final String NOME_MUNICAO_BAZUCA = " bala38ao ";
    private static final int ESPACO_TOTAL_MUNICAO_BAZUCA = 16;
    private static final int LINHAS_MUNICAO_BAZUCA = 2;
    private static final int COLUNAS_MUNICAO_BAZUCA = 8;
    private static final int UNIDADES_MUNICAO_BAZUCA = 1;

    public MissilDeBazuca() {
        super(ESPACO_TOTAL_MUNICAO_BAZUCA, NOME_MUNICAO_BAZUCA, ESPACO_MUNICAO_BAZUCA, PESO_MUNICAO_BAZUCA, LINHAS_MUNICAO_BAZUCA, COLUNAS_MUNICAO_BAZUCA);
    }
}
