package br.com.cwi.crescer.aula5;

public class Castelo {

    private String nomeDoCastelo;
    private int vidaDoCastelo;
    private Muro muro;

    public Castelo(){
        muro = new Muro(50);
    }

    public Castelo(String nomeDoCastelo, int vidaDoCastelo, Muro muro) {
        this.nomeDoCastelo = nomeDoCastelo;
        this.vidaDoCastelo = vidaDoCastelo;
        this.muro = muro;
    }

    public boolean casteloDestruido() {
        return this.vidaDoCastelo == 0;
    }

    public void receberDanoNoCastelo(int danoDaArma){
        this.vidaDoCastelo -= danoDaArma;
        if(vidaDoCastelo <= 0){
            casteloDestruido();
        }
    }

    public void receberDanoDosArietes(int danoDaArma) {
        if(muro.muroDestruido()){
            this.receberDanoNoCastelo(danoDaArma);
        }
        else{
            muro.receberDanoNoMuro(danoDaArma);
        }
    }

    public void receberDanoDaCatapulta(int danoDaArma){
        this.receberDanoNoCastelo(danoDaArma);
    }

    public int getVidaDoCastelo(){
        return vidaDoCastelo;
    }

    public int getVidaDoMuro(){
        return muro.getVidaDoMuro();
    }
}
