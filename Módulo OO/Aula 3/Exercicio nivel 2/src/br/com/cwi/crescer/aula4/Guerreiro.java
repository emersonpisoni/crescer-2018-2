package br.com.cwi.crescer.aula4;

public class Guerreiro {
    private int vida;
    private int forca;
    private int nivel;
    private Cavalo possuiCavalo;

    public Guerreiro() {
        this.vida = 1;
        this.forca = 1;
        this.nivel = 1;
    }

    public void subirDeNivel(){
        this.forca++;
        this.vida++;
        if(this.nivel % 2 == 0){
            this.forca++;
            this.vida++;
        }
        this.nivel++;
        if(possuiCavalo != null){
            this.possuiCavalo.subirDeNivel();
        }
    }

    public void treinaNaAcademiaDeEquitacao() {
        if(this.possuiCavalo == null){
            Cavalo cavalo = new Cavalo();
        }
    }

    private void equiparCavalo(){
        if(possuiCavalo == null){
            possuiCavalo = new Cavalo();
        }
    }

    public void treinaNaAcademiaDeEquitacao(Cavalo novoCavalo) {
        equiparCavalo();
    }


    public int getVida() {
        int vidaTotal = this.vida;
        if(possuiCavalo != null){
            vidaTotal += possuiCavalo.getVida() / 2;
        }
        return vidaTotal;
    }

    public int getPoderDeAtaque() {
        int poderDeAtaque = this.forca;
        if(possuiCavalo != null){
            poderDeAtaque += possuiCavalo.getForca();
        }
        return poderDeAtaque;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
