class Peca{

    constructor(valorOeste, valorLeste){  
        this.valorLeste = valorLeste
        this.valorOeste = valorOeste
        this.testaValor()
    }

    static get VALOR_MAXIMO() {
        return 6;
    }

    static get VALOR_MINIMO() {
        return 0;
    }

    testaValor(){
        if(this.valorLeste > 6 || this.valorOeste > 6){
            throw new PecaError("O número máximo de valor para cada lado é 6. ")
        }
        if(this.valorLeste < 0 || this.valorOeste < 0){
            throw new PecaError("O número mínimo de valor para cada lado é 0. ")
        }
    }

    podeEncaixar(outraPeca){
        if((this.valorLeste != outraPeca.valorOeste) && (this.valorOeste != outraPeca.valorLeste)){
            return false
        }
        else{
            return true
        }
    }
}