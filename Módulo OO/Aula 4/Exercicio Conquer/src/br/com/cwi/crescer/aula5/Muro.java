package br.com.cwi.crescer.aula5;

public class Muro {

    private int vidaDoMuro;

    public Muro(int vidaDoMuro) {
        this.vidaDoMuro = vidaDoMuro;
    }

    public void receberDanoNoMuro(int danoArma){
        vidaDoMuro -= danoArma;
        if(vidaDoMuro <= 0){
            muroDestruido();
        }
    }

    public boolean muroDestruido(){
        return this.vidaDoMuro == 0;
    }

    public int getVidaDoMuro() {
        return vidaDoMuro;
    }
}
