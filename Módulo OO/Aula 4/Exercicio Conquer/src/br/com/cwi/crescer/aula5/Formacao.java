package br.com.cwi.crescer.aula5;

public class Formacao {

    private static final int NUMERO_MAXIMO_DE_ARMAS_POSICIONADAS = 5;
    private int totalDeArmasPosicionadas;
    private int danoTotalDaFormacao;
    private Castelo castelo;

    private Arma umaArma;
    private Arma duasArmas;
    private Arma tresArmas;
    private Arma quatroArmas;
    private Arma cincoArmas;

    public Formacao(){
        this.castelo = new Castelo();
    }

    public Formacao(Castelo castelo){
        this.castelo = castelo;
    }

    public boolean posicionarArma(Arma arma){
        boolean podePosicionarrArma = totalDeArmasPosicionadas < NUMERO_MAXIMO_DE_ARMAS_POSICIONADAS;
        if(podePosicionarrArma){
            if (totalDeArmasPosicionadas == 0){
                this.umaArma = arma;
            }
            if (totalDeArmasPosicionadas == 1){
                this.duasArmas = arma;
            }
            if (totalDeArmasPosicionadas == 2){
                this.tresArmas = arma;
            }
            if (totalDeArmasPosicionadas == 3){
                this.quatroArmas = arma;
            }
            if (totalDeArmasPosicionadas == 4){
                this.cincoArmas = arma;
            }
            this.totalDeArmasPosicionadas++;
            this.danoTotalDaFormacao += arma.getDanoDaArma();
            return true;
        }
        return false;
    }

    public void atacarEmFormacao(){
        if(totalDeArmasPosicionadas == 1){
            umaArma.atacarCastelo(this.castelo);
        }
        if(totalDeArmasPosicionadas == 2){
            duasArmas.atacarCastelo(this.castelo);
        }
        if(totalDeArmasPosicionadas == 3){
            tresArmas.atacarCastelo(this.castelo);
        }
        if(totalDeArmasPosicionadas == 4){
            quatroArmas.atacarCastelo(this.castelo);
        }
        if (totalDeArmasPosicionadas == 5){
            cincoArmas.atacarCastelo(this.castelo);
        }

    }

    public int getDanoTotalDaFormacao(){
        return danoTotalDaFormacao;
    }
}
