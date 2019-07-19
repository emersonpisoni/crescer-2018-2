package test.br.com.cwi.crescer.SuperMarioWorld;

import br.com.cwi.crescer.SuperMarioWorld.*;
import br.com.cwi.crescer.SuperMarioWorld.Elementos.Itens.CapeFeather;
import br.com.cwi.crescer.SuperMarioWorld.Elementos.Itens.FireFlower;
import br.com.cwi.crescer.SuperMarioWorld.Elementos.Obstaculos.Buraco;
import br.com.cwi.crescer.SuperMarioWorld.Elementos.Obstaculos.Cano;
import br.com.cwi.crescer.SuperMarioWorld.Elementos.Obstaculos.Inimigos.ChainChomp;
import br.com.cwi.crescer.SuperMarioWorld.Elementos.Obstaculos.Inimigos.Goomba;
import br.com.cwi.crescer.SuperMarioWorld.Elementos.Obstaculos.Inimigos.KoopraTroopa;
import br.com.cwi.crescer.SuperMarioWorld.Elementos.Obstaculos.Inimigos.PiranhaPlant;
import br.com.cwi.crescer.SuperMarioWorld.Herois.Luigi;
import br.com.cwi.crescer.SuperMarioWorld.Herois.Mario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CriadorDeMapaTest {

    @Test
    void adicionarElemento() throws PosicaoOcupadaException {

        CriadorDeMapa criadorDeMapa = new CriadorDeMapa(5);

        criadorDeMapa.adicionarElemento(new Mario(), 0);
        criadorDeMapa.adicionarElemento(new PiranhaPlant(), 1);
        criadorDeMapa.adicionarElemento(new KoopraTroopa(), 2);

        System.out.println(criadorDeMapa.mostrarMapa());
        assertEquals("|M|P|K| | |", criadorDeMapa.mostrarMapa());
    }

    @Test
    void adicionarHeroi() throws PosicaoOcupadaException {
        CriadorDeMapa criadorDeMapa = new CriadorDeMapa(5);
        criadorDeMapa.adicionarElemento(new Mario(), 2);

        System.out.println(criadorDeMapa.mostrarMapa());
        assertEquals("| | |M| | |", criadorDeMapa.mostrarMapa());
    }

    @Test
    void marioDeveConseguirPassarPeloChaimChompComUmaCapeFeather() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new CapeFeather(), 2);
        mapa.adicionarElemento(new ChainChomp(), 5);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertTrue(possivelCompletarFase);
    }

    @Test
    void testaExceptionHeroiJaAdicionado() throws PosicaoOcupadaException, HeroiJaAdicionadoException {

        CriadorDeMapa mapa = new CriadorDeMapa(4);

        mapa.adicionarHeroi(new Mario(), 0);

        assertThrows(HeroiJaAdicionadoException.class, () -> mapa.adicionarHeroi(new Luigi(), 1));
    }

    @Test
    void testaExceptionPosicaoOcupada() throws PosicaoOcupadaException, HeroiJaAdicionadoException {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarElemento(new Goomba(), 0);

        assertThrows(PosicaoOcupadaException.class, () -> mapa.adicionarElemento(new PiranhaPlant(), 0));
    }

    @Test
    void testaChaimChompNaUltimaPosicaoSendoImpossivelDeVencer() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new ChainChomp(), 6);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertFalse(possivelCompletarFase);
    }

    @Test
    void testaChaimChffompNoMeioENaUltimaPosicaoSendoImpossivelDeVencer() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new CapeFeather(), 1);
        mapa.adicionarElemento(new ChainChomp(), 2);
        mapa.adicionarElemento(new ChainChomp(), 6);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertFalse(possivelCompletarFase);
    }

    @Test
    void testaMatar2KoopaTroopaEReceber40Moedas() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new KoopraTroopa(), 3);
        mapa.adicionarElemento(new KoopraTroopa(), 4);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertEquals(40, mapa.getMoedasArrecadadas());
        assertTrue(possivelCompletarFase);
    }

    @Test
    void testaMatar2GoombaEReceber20Moedas() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new Goomba(), 3);
        mapa.adicionarElemento(new Goomba(), 4);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertEquals(20, mapa.getMoedasArrecadadas());
        assertTrue(possivelCompletarFase);
    }

    @Test
    void testaMatar1GoombaE1KoopaTroopaReceber30Moedas() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new Goomba(), 3);
        mapa.adicionarElemento(new KoopraTroopa(), 4);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertEquals(30, mapa.getMoedasArrecadadas());
        assertTrue(possivelCompletarFase);
    }

    @Test
    void testaMatarPiranhaPlantSemFireFlower() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new PiranhaPlant(), 3);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertFalse(possivelCompletarFase);
    }

    @Test
    void testaMatarPiranhaPlantComFireFlower() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new FireFlower(), 2);
        mapa.adicionarElemento(new PiranhaPlant(), 3);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertTrue(possivelCompletarFase);
        assertEquals(50, mapa.getMoedasArrecadadas());
    }

    @Test
    void testaPular1Buraco() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new Buraco(), 2);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertTrue(possivelCompletarFase);
    }

    @Test
    void testaPular2BuracosJuntosComEspaco() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new Buraco(), 2);
        mapa.adicionarElemento(new Buraco(), 3);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertTrue(possivelCompletarFase);
    }

    @Test
    void testaPular2BuracosJuntosSemEspaco() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new Buraco(), 1);
        mapa.adicionarElemento(new Buraco(), 2);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertFalse(possivelCompletarFase);
    }

    @Test
    void testaPular3BuracosJuntosComEspaco() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new Buraco(), 3);
        mapa.adicionarElemento(new Buraco(), 4);
        mapa.adicionarElemento(new Buraco(), 5);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertTrue(possivelCompletarFase);
    }

    @Test
    void testaPular3BuracosJuntosSemEspaco() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new Buraco(), 1);
        mapa.adicionarElemento(new Buraco(), 2);
        mapa.adicionarElemento(new Buraco(), 3);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertFalse(possivelCompletarFase);
    }

    @Test
    void testaPular2BuracosComluigiOQueOMarioNaoConseguiu() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Luigi(), 0);
        mapa.adicionarElemento(new Buraco(), 1);
        mapa.adicionarElemento(new Buraco(), 2);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertTrue(possivelCompletarFase);
    }

    @Test
    void testaPular3BuracosComluigiSemEspaco() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Luigi(), 0);
        mapa.adicionarElemento(new Buraco(), 1);
        mapa.adicionarElemento(new Buraco(), 2);
        mapa.adicionarElemento(new Buraco(), 3);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertTrue(possivelCompletarFase);
    }

    @Test
    void testaPular4BuracosComluigiCom1DeEspaco() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Luigi(), 0);
        mapa.adicionarElemento(new Buraco(), 1);
        mapa.adicionarElemento(new Buraco(), 2);
        mapa.adicionarElemento(new Buraco(), 3);
        mapa.adicionarElemento(new Buraco(), 4);


        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertFalse(possivelCompletarFase);
    }

    @Test
    void testaMatarUmInimigoDepoisDePularUmBuraco() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Luigi(), 0);
        mapa.adicionarElemento(new Buraco(), 1);
        mapa.adicionarElemento(new KoopraTroopa(), 2);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertTrue(possivelCompletarFase);
    }

    @Test
    void testaPularUmChaimChompSemPeninhaDepoisDePularUmBuraco() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new Buraco(), 1);
        mapa.adicionarElemento(new ChainChomp(), 2);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertFalse(possivelCompletarFase);
    }

    @Test
    void testaPularUmChaimChompComPeninhaDepoisDePularUmBuraco() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new CapeFeather(), 1);
        mapa.adicionarElemento(new Buraco(), 2);
        mapa.adicionarElemento(new ChainChomp(), 3);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertTrue(possivelCompletarFase);
    }

    @Test
    void testaMatarUmPiranhaPlantComFireFlowerDepoisDePularUmBuraco() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new FireFlower(), 1);
        mapa.adicionarElemento(new Buraco(), 2);
        mapa.adicionarElemento(new PiranhaPlant(), 3);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertTrue(possivelCompletarFase);
    }

    @Test
    void marioNaoPodeMatarUmPiranhaPlantSemFireFlowerDepoisDePularUmBuraco() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new Buraco(), 2);
        mapa.adicionarElemento(new PiranhaPlant(), 3);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertFalse(possivelCompletarFase);
    }

    @Test
    void luigiNaoDevePularPqNaoTemAFireFlower() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Luigi(), 0);
        mapa.adicionarElemento(new Buraco(), 2);
        mapa.adicionarElemento(new Buraco(), 3);
        mapa.adicionarElemento(new Buraco(), 4);
        mapa.adicionarElemento(new Buraco(), 5);
        mapa.adicionarElemento(new PiranhaPlant(), 6);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertFalse(possivelCompletarFase);
    }

    @Test
    void test() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new Cano(0), 3);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertTrue(possivelCompletarFase);
    }

    @Test
    void testaMarioPulandoCanoDeTamanho1() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new Cano(1), 1);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertFalse(possivelCompletarFase);
    }

    @Test
    void testaMarioPulandoCanoDeTamanho0() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);
        mapa.adicionarElemento(new Cano(0), 1);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertTrue(possivelCompletarFase);
    }

    @Test
    void testaLuigiPulandoDoisBuracosComUmChaimChompNoMeio() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Luigi(), 0);
        mapa.adicionarElemento(new Buraco(), 1);
        mapa.adicionarElemento(new ChainChomp(), 2);
        mapa.adicionarElemento(new Buraco(), 3);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertFalse(possivelCompletarFase);
    }

    @Test
    void testaLuigiPulandoDoisBuracosComUmChaimChompNoMeioMasComPeninha() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Luigi(), 0);
        mapa.adicionarElemento(new CapeFeather(), 1);
        mapa.adicionarElemento(new Buraco(), 2);
        mapa.adicionarElemento(new ChainChomp(), 3);
        mapa.adicionarElemento(new Buraco(), 4);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertTrue(possivelCompletarFase);
    }

    @Test
    void semCapaNaoVaiRolar() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Luigi(), 0);
        mapa.adicionarElemento(new ChainChomp(), 3);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertFalse(possivelCompletarFase);
    }

    @Test
    void masComCapaRola() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Luigi(), 0);
        mapa.adicionarElemento(new CapeFeather(), 1);
        mapa.adicionarElemento(new ChainChomp(), 3);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertTrue(possivelCompletarFase);
    }

    @Test
    void aquiNaoVaiRolar() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Luigi(), 0);
        mapa.adicionarElemento(new Cano(0), 1);
        mapa.adicionarElemento(new Cano(0), 2);
        mapa.adicionarElemento(new Cano(0), 3);
        mapa.adicionarElemento(new Cano(0), 4);
        mapa.adicionarElemento(new Cano(0), 5);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertFalse(possivelCompletarFase);
    }

    @Test
    void comAPenaVaiConseguirSaltarTudo() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 0);

        mapa.adicionarElemento(new CapeFeather(), 1);
        mapa.adicionarElemento(new Cano(99), 3);
        mapa.adicionarElemento(new Cano(99), 4);
        mapa.adicionarElemento(new PiranhaPlant(), 5);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertTrue(possivelCompletarFase);
    }

    @Test
    void naoConsegueNeMario() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 1);

        mapa.adicionarElemento(new Cano(2), 3);
        mapa.adicionarElemento(new Cano(2), 4);
        mapa.adicionarElemento(new Goomba(), 5);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertFalse(possivelCompletarFase);
    }

    @Test
    void comPenaOMarioConsegueSaltarEssesBuracos() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(8);

        mapa.adicionarHeroi(new Mario(), 1);

        mapa.adicionarElemento(new CapeFeather(), 2);
        mapa.adicionarElemento(new Buraco(), 3);
        mapa.adicionarElemento(new Buraco(), 4);
        mapa.adicionarElemento(new Buraco(), 5);
        mapa.adicionarElemento(new Buraco(), 6);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertTrue(possivelCompletarFase);
    }

    @Test
    void naoRolaSaltarEssesBuracosPqNaoTemOndeAterrizarDoOutroLado() throws PosicaoOcupadaException, HeroiJaAdicionadoException, NaoEPossivelCompletarAFase {

        CriadorDeMapa mapa = new CriadorDeMapa(7);

        mapa.adicionarHeroi(new Mario(), 1);

        mapa.adicionarElemento(new CapeFeather(), 2);
        mapa.adicionarElemento(new Buraco(), 3);
        mapa.adicionarElemento(new Buraco(), 4);
        mapa.adicionarElemento(new Buraco(), 5);
        mapa.adicionarElemento(new Buraco(), 6);

        SuperComputadorQueSabeJogarMario computador = new SuperComputadorQueSabeJogarMario();

        boolean possivelCompletarFase = computador.executarSimulacao(mapa);

        assertFalse(possivelCompletarFase);
    }


}