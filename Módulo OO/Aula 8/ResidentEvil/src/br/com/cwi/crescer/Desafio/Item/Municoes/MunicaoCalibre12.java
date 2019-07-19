package br.com.cwi.crescer.Desafio.Item.Municoes;

import br.com.cwi.crescer.Desafio.Item.Item;

public class MunicaoCalibre12 extends Item {

    private static final String[][] ESPACO_MUNICAO_CALIBRE = new String[2][1];
    private static final int PESO_MUNICAO_CALIBRE = 1;
    private static final String NOME_MUNICAO_CALIBRE = " bala12 ";
    private static final int ESPACO_TOTAL_MUNICAO_CALIBRE = 2;
    private static final int LINHAS_MUNICAO_CALIBRE = 2;
    private static final int COLUNAS_MUNICAO_CALIBRE = 1;
    private static final int UNIDADES_MUNICAO_TRES8AO = 8;

    public MunicaoCalibre12() {
        super(ESPACO_TOTAL_MUNICAO_CALIBRE, NOME_MUNICAO_CALIBRE, ESPACO_MUNICAO_CALIBRE, PESO_MUNICAO_CALIBRE, LINHAS_MUNICAO_CALIBRE, COLUNAS_MUNICAO_CALIBRE);
    }
}
