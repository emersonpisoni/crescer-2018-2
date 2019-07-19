package br.com.cwi.crescer.mortalkombat1.Partida;

import br.com.cwi.crescer.mortalkombat1.Jogadores.Jogador;
import br.com.cwi.crescer.mortalkombat1.Personagens.Personagem;

public class Partida {

    private String perdedor;
    private String vencedor;
    private Jogador jogador1;
    private Jogador jogador2;
    private Personagem personagem;

    public Partida(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }



    public String getPerdedor() {
        return perdedor;
    }

    public String getVencedor(){
        return vencedor;
    }

    public void iniciarBatalha() {

        while(this.perdedor == null){
            for (int i = 0; i < jogador1.getPersonagens().size(); i++) {
                if(jogador1.getPersonagens().get(i).morto()) {
                    jogador1.getPersonagens().remove(i);
                }
            }

            for (int i = 0; i < jogador2.getPersonagens().size(); i++) {
                if(jogador2.getPersonagens().get(i).morto()){
                    jogador2.getPersonagens().remove(i);
                }
            }

            if(jogador1.getPersonagens().size() > 0 && jogador2.getPersonagens().size() > 0){
                jogador1.getPersonagens().get(0).realizarAtaque(jogador2.getPersonagens().get(0));
            }
            if(jogador1.getPersonagens().size() > 0 && jogador2.getPersonagens().size() > 0){
                jogador2.getPersonagens().get(0).realizarAtaque(jogador1.getPersonagens().get(0));
            }
            if(jogador1.getPersonagens().size() == 0){
                this.perdedor = jogador1.getNomeDoJogador();
                this.vencedor = jogador2.getNomeDoJogador();
            }
            if(jogador2.getPersonagens().size() == 0){
                this.perdedor = jogador2.getNomeDoJogador();
                this.vencedor = jogador1.getNomeDoJogador();
            }

        }

    }

}
