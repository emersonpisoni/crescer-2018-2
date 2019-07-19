package br.com.cwi.crescer.aula5.Partida;

import br.com.cwi.crescer.aula5.Jogadores.Jogador;
import br.com.cwi.crescer.aula5.Jogadores.Maquina;

public class Partida {

    private String perdedor;
    private String vencedor;
    private Jogador jogador;
    private Jogador jogador1;
    private Jogador jogador2;
    private Maquina maquina;

    public Partida(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public Partida(Jogador jogador){
        this.jogador = jogador;
        this.maquina = new Maquina("Maquina", jogador.getPersonagens().size());
        maquina.adicionarPersonagensParaMaquina();
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

    public void iniciarBatalhaVSMaquina() {

        while(this.perdedor == null){
            for (int i = 0; i < jogador.getPersonagens().size(); i++) {
                if(jogador.getPersonagens().get(i).morto()) {
                    jogador.getPersonagens().remove(i);
                }
            }

            for (int i = 0; i < maquina.getPersonagens().size(); i++) {
                if(maquina.getPersonagens().get(i).morto()){
                    maquina.getPersonagens().remove(i);
                }
            }

            if(jogador.getPersonagens().size() > 0 && maquina.getPersonagens().size() > 0){
                jogador.getPersonagens().get(0).realizarAtaque(maquina.getPersonagens().get(0));
            }
            if(jogador.getPersonagens().size() > 0 && maquina.getPersonagens().size() > 0){
                maquina.getPersonagens().get(0).realizarAtaque(jogador.getPersonagens().get(0));
            }
            if(jogador.getPersonagens().size() == 0){
                this.perdedor = jogador.getNomeDoJogador();
                this.vencedor = maquina.getNomeMaquina();
            }
            if(maquina.getPersonagens().size() == 0){
                this.perdedor = maquina.getNomeMaquina();
                this.vencedor = jogador.getNomeDoJogador();
            }

        }


    }

}
