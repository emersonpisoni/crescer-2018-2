package br.com.cwi.crescer.aula5.Personagens;

public abstract class Personagem {
    protected String nomeDoPersonagem;
    protected int danoDeAtaque;
    protected int vida;
    protected int quantidadeDeVezesQueAtacou = 0;
    protected int quantidadeDeVezesQueRecebeuDano = 0;

    public Personagem(String nomeDoPersonagem, int danoDeAtaque, int vida, int quantidadeDeVezesQueAtacou, int quantidadeDeVezesQueRecebeuDano) {
        this.nomeDoPersonagem = nomeDoPersonagem;
        this.danoDeAtaque = danoDeAtaque;
        this.vida = vida;
        this.quantidadeDeVezesQueAtacou = quantidadeDeVezesQueAtacou;
        this.quantidadeDeVezesQueRecebeuDano = quantidadeDeVezesQueRecebeuDano;
    }

    public void receberDano(int danoDeAtaque){
        if(this.vida > 0){
            this.vida -= danoDeAtaque;
        }
        else{
            this.vida = 0;
        }
    }

    public boolean morto(){
        return vida <= 0;
    }

    public abstract void realizarAtaque(Personagem personagenAlvo);

    public int getDanoDeAtaque() {
        return danoDeAtaque;
    }

    public int getVida() {
        return vida;
    }

}
