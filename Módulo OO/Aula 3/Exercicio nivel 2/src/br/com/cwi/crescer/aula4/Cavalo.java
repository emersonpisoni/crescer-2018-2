package br.com.cwi.crescer.aula4;

public class Cavalo {
    private int vida;
    private int forca;
    private int nivel;

    public Cavalo() {
        this.vida = 2;
        this.forca = 1;
        this. nivel = 1;
    }

    public void subirDeNivel(){
        this.vida *=2 ;
        this.forca *=2 ;
        this.nivel = 1;
    }

    public int getVida() {
        return vida;
    }

    public int getForca() {
        return forca;
    }

    public int getNivel() {
        return nivel;
    }
}
