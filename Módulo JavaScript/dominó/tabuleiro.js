class Tabuleiro{

    constructor(){
        this.pecasDoTabuleiro = []
    }

    adicionarPecaAoOeste(peca){
        if(this.pecasDoTabuleiro.length == 0){
            this.pecasDoTabuleiro[0] = peca
            this.valorOeste = peca.valorOeste
            this.valorLeste = peca.valorLeste
        }

        else if(this.pecasDoTabuleiro.length != 0){
            for (let i = 0; i < this.pecasDoTabuleiro.length; i++) {
                if(this.pecasDoTabuleiro[i] != 0){

                    if(this.pecasDoTabuleiro[i].valorLeste == peca.valorLeste && this.pecasDoTabuleiro[i].valorOeste == peca.valorOeste){
                        throw new JogadaInvalidaError()
                    }
                    else if(this.pecasDoTabuleiro[i].valorLeste == peca.valorOeste && this.pecasDoTabuleiro[i].valorOeste == peca.valorLeste){
                        throw new JogadaInvalidaError()
                    }
                    
                    else if(this.valorOeste != peca.valorLeste){
                        throw new JogadaInvalidaError()
                    }   
                }       
            }
        }
        if(this.valorOeste == peca.valorLeste){
            this.pecasDoTabuleiro.unshift(peca)
            this.valorOeste = peca.valorOeste
        }
    }

    adicionarPecaAoLeste(peca){
        if(this.pecasDoTabuleiro.length == 0){
            this.pecasDoTabuleiro[0] = peca
            this.valorOeste = peca.valorOeste
            this.valorLeste = peca.valorLeste
        }
        else if(this.valorLeste == peca.valorOeste){
            this.pecasDoTabuleiro.push(peca)
            this.valorLeste = peca.valorLeste
        }
        else if(this.valorLeste != peca.valorOeste){
            throw new JogadaInvalidaError()
        }
    }
}