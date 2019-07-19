package br.com.cwi.crescer.Desafio;

import br.com.cwi.crescer.Desafio.Item.Item;

public class Inventario {
    private String[][] inventario;
    private Item item;
    private int espacosDisponiveis;


    public Inventario(int linhasMaleta, int colunasMaleta) {
        this.inventario = new String[linhasMaleta][colunasMaleta];
    }

    public int TamanhoMaleta() {
        int inventarioTamanho = 0;
        for (int i = 0; i < inventario.length; i++) {
            for (int j = 0; j < inventario[i].length; j++) {
                inventarioTamanho++;
            }
        }
        return inventarioTamanho;
    }

    public void espacosDisponives() {
        this.espacosDisponiveis = 0;
        for (int i = 0; i < this.inventario.length; i++) {
            for (int j = 0; j < this.inventario[i].length; j++) {
                if (inventario[i][j] == null) {
                    espacosDisponiveis++;
                }
            }
        }
    }

    public void adicionarItemComTamanho1(int linhasItem, int colunasItem, Item item) {
        espacosDisponives();
        if (this.espacosDisponiveis > item.getEspacoTotalItem())
            this.inventario[linhasItem][colunasItem] = item.getNome();
        espacosDisponives();
    }

    public void verificaSlotParaAdicionar(Item item) {

        for (int i = 0; i < this.inventario.length; i++) {
            for (int j = 0; j < this.inventario[i].length; j++) {
                if (inventario[i][j] == null) {
                    for (int k = i; k < item.getLinhasItem() + i; k++) {
                        for (int l = j; l < item.getColunasItem() + j; l++) {
                            inventario[k][l] = item.getNome();
                        }
                    }break;
                }
            }return;
        }
    }

    public void removerItemComTamanho1(int linhasItem, int colunasItem) {
        this.inventario[linhasItem][colunasItem] = null;
        espacosDisponives();
    }

    private boolean isSlotOcupado(int linhaItem, int colunaItem) {
        return this.inventario[linhaItem][colunaItem] != null;
    }


    public void MostrarMaleta() {
        for (int i = 0; i < this.inventario.length; i++) {
            for (int j = 0; j < this.inventario[i].length; j++) {
                boolean slotOcupado = this.isSlotOcupado(i, j);
                if (slotOcupado) {
                    System.out.print(inventario[i][j]);
                } else {
                    System.out.print(" [EMPTY] ");
                }
            }
            System.out.println();
        }
    }

    public int getEspacosDisponiveis() {
        return this.espacosDisponiveis;
    }
}
