package br.com.cwi.crescer.Desafio.Item;

public abstract class Item {

    private int peso;
    private int espacoTotalItem;
    private int linhasItem;
    private int colunasItem;
    private String nome;
    private String[][] tamanoNaMaleta;

    public Item(int peso, String nome, String[][] tamanoNaMaleta, int espacoTotalItem,int linhasItem, int colunasItem) {
        this.peso = peso;
        this.nome = nome;
        this.tamanoNaMaleta = tamanoNaMaleta;
        this.espacoTotalItem = espacoTotalItem;
        this.linhasItem = linhasItem;
        this.colunasItem = colunasItem;
    }

    public String getNome() {
        return nome;
    }

    public int getPeso() {
        return peso;
    }

    public String[][] getTamanoNaMaleta() {
        return tamanoNaMaleta;
    }

    public int getEspacoTotalItem() {
        return espacoTotalItem;
    }

    public int getLinhasItem() {
        return linhasItem;
    }

    public int getColunasItem() {
        return colunasItem;
    }
}
