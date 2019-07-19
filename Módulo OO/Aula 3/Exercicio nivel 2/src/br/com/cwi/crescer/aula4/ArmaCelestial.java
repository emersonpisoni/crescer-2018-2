package br.com.cwi.crescer.aula4;

public class ArmaCelestial {
    private int vida;
    private int poderCelestial;

    public ArmaCelestial(int vidaAcrescida) {
        this.poderCelestial = 20;
        this.vida= vidaAcrescida;
    }

    public int getVidaAcrescida() {
        return vida;
    }

    public int getPoderCelestial() {
        return poderCelestial;
    }
}
