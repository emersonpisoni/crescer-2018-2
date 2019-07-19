package br.com.cwi.crescer.Desafio.Item.Armas;

import br.com.cwi.crescer.Desafio.Item.Item;

public class Tres8a0 extends Item implements Arma {

    private static final String[][] ESPACO_TRES8AO = new String[3][2];
    private static final int PESO_TRES8AO = 2;
    private static final String NOME_TRES8AO = " Tres8ao ";
    private static final int ESPACO_TOTAL_TRES8AO = 6;
    private static final int LINHAS_TRES8AO = 3;
    private static final int COLUNAS_TRES8AO = 2;

    public Tres8a0() {
        super(PESO_TRES8AO, NOME_TRES8AO, ESPACO_TRES8AO, ESPACO_TOTAL_TRES8AO, LINHAS_TRES8AO, COLUNAS_TRES8AO);
    }

    @Override
    public void atirar() {

    }

    @Override
    public void recarregar() {

    }

    public static String[][] getEspacoTres8ao() {
        return ESPACO_TRES8AO;
    }

    public static int getPesoTres8ao() {
        return PESO_TRES8AO;
    }

    public static String getNomeTres8ao() {
        return NOME_TRES8AO;
    }

    public static int getEspacoTotalTres8ao() {
        return ESPACO_TOTAL_TRES8AO;
    }
}
