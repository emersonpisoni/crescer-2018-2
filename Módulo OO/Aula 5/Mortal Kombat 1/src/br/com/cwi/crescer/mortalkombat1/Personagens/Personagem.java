package br.com.cwi.crescer.mortalkombat1.Personagens;

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
        return vida == 0;
    }

    public abstract void realizarAtaque(Personagem personagenAlvo);

    public int getDanoDeAtaque() {
        return danoDeAtaque;
    }

    public int getVida() {
        return vida;
    }

    public int getQuantidadeDeVezesQueRecebeuDano() {
        return quantidadeDeVezesQueRecebeuDano;
    }

    public int getQuantidadeDeVezesQueAtacou() {
        return quantidadeDeVezesQueAtacou;
    }

    public void setQuantidadeDeVezesQueAtacou(int quantidadeDeVezesQueAtacou) {
        this.quantidadeDeVezesQueAtacou = quantidadeDeVezesQueAtacou;
    }

    public void setQuantidadeDeVezesQueRecebeuDano(int quantidadeDeVezesQueRecebeuDano) {
        this.quantidadeDeVezesQueRecebeuDano = quantidadeDeVezesQueRecebeuDano;
    }

}
