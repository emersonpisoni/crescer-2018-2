package test.br.com.cwi.crescer.Desafio;

import br.com.cwi.crescer.Desafio.Inventario;
import br.com.cwi.crescer.Desafio.Item.Armas.Calibre12;
import br.com.cwi.crescer.Desafio.Item.Armas.Tres8a0;
import br.com.cwi.crescer.Desafio.Item.Municoes.MunicaoCalibre12;
import br.com.cwi.crescer.Desafio.Item.Municoes.MunicaoTres8ao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventarioTest {

    @Test
    void testaTamanhoMaleta(){
        Inventario inventario = new Inventario(5,4);

        assertEquals(20, inventario.TamanhoMaleta());
    }

    @Test
    void verificaEspacosDisponiveis() {
        Inventario inventario = new Inventario(6,5);
        inventario.espacosDisponives();

        assertEquals(30, inventario.getEspacosDisponiveis());
    }

    @Test
    void imprimiInventario(){
        Inventario inventario = new Inventario(5, 5);
        Tres8a0 tres8a0 = new Tres8a0();
        inventario.adicionarItemComTamanho1(1,2, tres8a0);
        inventario.adicionarItemComTamanho1(0,0, tres8a0);
        inventario.MostrarMaleta();

        assertEquals(23, inventario.getEspacosDisponiveis());
    }

    @Test
    void removerItens(){
        Inventario inventario = new Inventario(4,4);
        Tres8a0 tres8a0 = new Tres8a0();
        inventario.adicionarItemComTamanho1(0,0,tres8a0);
        assertEquals(16, inventario.TamanhoMaleta());
        assertEquals(15, inventario.getEspacosDisponiveis());
        inventario.removerItemComTamanho1(0,0);

        assertEquals(16, inventario.getEspacosDisponiveis());
    }

    @Test
    void adicionarItensComMatriz(){
        Inventario inventario = new Inventario(5,3);
        Tres8a0 tres8a0 = new Tres8a0();
        MunicaoCalibre12 municaoCalibre12 = new MunicaoCalibre12();
        inventario.verificaSlotParaAdicionar(tres8a0);
        inventario.verificaSlotParaAdicionar(municaoCalibre12);
        inventario.MostrarMaleta();
        inventario.espacosDisponives();
        assertEquals(7 , inventario.getEspacosDisponiveis());
    }

    @Test
    void testTamanhoTres8ao(){
        Inventario inventario = new Inventario(3,3);
        Tres8a0 tres8a0 = new Tres8a0();
        assertEquals(6, tres8a0.getEspacoTotalItem());
    }

}