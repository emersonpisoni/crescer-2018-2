package br.com.cwi.crescer.aula7;

import java.util.HashMap;
import java.util.Map;


public class InglesEspanhol {

    PortuguesIngles portuguesIngles;
    PortuguesEspanhol portuguesEspanhol;
    private String palavraIngles;
    private Map<String, String> mapInglesEspanhol;

    public InglesEspanhol(String palavraIngles) {
        this.palavraIngles = palavraIngles;
    }

    public String getTradutorInglesEspanhol(){

        StringBuilder fraseInglesEspanhol = new StringBuilder();

        for (Map.Entry<String, String> entry : mapInglesEspanhol.entrySet()) {
            mapInglesEspanhol.put(entry.getKey(), mapInglesEspanhol.get(entry.getValue()));
        }
        return fraseInglesEspanhol.toString();
    }
}
