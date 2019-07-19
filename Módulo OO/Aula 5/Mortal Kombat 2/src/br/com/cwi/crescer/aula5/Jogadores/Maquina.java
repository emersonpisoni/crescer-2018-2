package br.com.cwi.crescer.aula5.Jogadores;

import br.com.cwi.crescer.aula5.Personagens.*;

public class Maquina extends Jogador {

    private int quantidadeDePersonagens;
    private String nomeMaquina;
    private Personagem personagem = null;

    public Maquina(String nomeMaquina, int quantidadeDePersonagensAleatorios) {
        this.quantidadeDePersonagens = quantidadeDePersonagensAleatorios;
        this.nomeMaquina = nomeMaquina;
    }

    public String getNomeMaquina(){
        return nomeMaquina;
    }

    public Personagem adicionarPersonagensParaMaquina() {
        for (int i = 0; i < quantidadeDePersonagens; i++) {
            int sortearNumero = (int) (1 + (Math.random() * 6));
            switch (sortearNumero) {
                case 1:
                    super.adcionarPersonagem(new ShaoKahn());
                    break;
                case 2:
                    super.adcionarPersonagem(new SoniaBlade());
                    break;
                case 3:
                    super.adcionarPersonagem(new Scorpion());
                    break;
                case 4:
                    super.adcionarPersonagem(new SubZero());
                    break;
                case 5:
                    super.adcionarPersonagem(new LiuKang());
                    break;
                case 6:
                    super.adcionarPersonagem(new Raiden());
                    break;
            }

        }
        return personagem;

    }

}
