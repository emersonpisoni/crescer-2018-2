package br.com.cwi.crescer.Desafio.Item.Armas;

import br.com.cwi.crescer.Desafio.Item.Item;

public class Calibre12 extends Item implements Arma{

    private static final String[][] ESPACO_CALIBRE = new String[3][7];
    private static final int PESO_CALIBRE = 2;
    private static final String NOME_CALIBRE = " Calibre12 ";
    private static final int ESPACO_TOTAL_CALIBRE = 21;
    private static final int LINHAS_CALIBRE = 3;
    private static final int COLUNAS_CALIBRE = 2;

    public Calibre12() {
        super(PESO_CALIBRE, NOME_CALIBRE, ESPACO_CALIBRE, ESPACO_TOTAL_CALIBRE, LINHAS_CALIBRE, COLUNAS_CALIBRE);
    }

    @Override
    public void atirar() {

    }

    @Override
    public void recarregar() {

    }

    public static String[][] getEspacoCalibre() {
        return ESPACO_CALIBRE;
    }

    public static int getPesoCalibre() {
        return PESO_CALIBRE;
    }

    public static String getNomeCalibre() {
        return NOME_CALIBRE;
    }

    public static int getEspacoTotalCalibre() {
        return ESPACO_TOTAL_CALIBRE;
    }

    public static int getLinhasCalibre() {
        return LINHAS_CALIBRE;
    }

    public static int getColunasCalibre() {
        return COLUNAS_CALIBRE;
    }
}
