package br.com.cwi.crescer.doom;

public class Demonio {

    private int vidaTotal = 300;

    public void receberDano(int danoArma) {
        vidaTotal -= danoArma;

        if(vidaTotal <= 0) morrer();
    }

    public void morrer(){
        vidaTotal = 0;
    }
}
