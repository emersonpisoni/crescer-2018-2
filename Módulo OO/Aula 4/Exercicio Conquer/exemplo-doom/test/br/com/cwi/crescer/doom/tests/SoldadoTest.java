package br.com.cwi.crescer.doom.tests;

import br.com.cwi.crescer.doom.*;
import br.com.cwi.crescer.doom.Doze;
import br.com.cwi.crescer.doom.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoldadoTest {

    @Test
    void soldadoDevePoderAtirarComQualquerTipoDeArma() {

        Soldado soldado = new Soldado();

        BFG bfg = new BFG();
        Doze doze = new Doze();
        Pistola pistola = new Pistola();

        Demonio demonioUm = new Demonio();
        Demonio demonioDois = new Demonio();
        Demonio demonioTres = new Demonio();

        soldado.equiparArma(doze);

        soldado.atirar(demonioUm);
    }
}















