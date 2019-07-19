package br.com.cwi.crescer.aula7;

import java.util.HashMap;
import java.util.Map;

public class PortuguesEspanhol {

    private String palavraPortugues;
    private Map<String, String> dicionarioPortuguesEspanhol;

    public PortuguesEspanhol(String palavraPortugues) throws NaoHouveTraducaoException {
        this.palavraPortugues = palavraPortugues;
        getTradutorPortuguesEspanhol();
    }

    public String getPalavraPortugues() {
        return palavraPortugues;
    }

    public Map<String, String> getDicionarioPortuguesEspanhol() {
        return dicionarioPortuguesEspanhol;
    }

    public String getTradutorPortuguesEspanhol() throws NaoHouveTraducaoException{
        this.dicionarioPortuguesEspanhol = new HashMap<>();
        this.dicionarioPortuguesEspanhol.put("você", "usted");
        this.dicionarioPortuguesEspanhol.put("diz","dice");
        this.dicionarioPortuguesEspanhol.put("sim", "sí");
        this.dicionarioPortuguesEspanhol.put("eu", "yo");
        this.dicionarioPortuguesEspanhol.put("digo", "dice");
        this.dicionarioPortuguesEspanhol.put("não", "no");
        this.dicionarioPortuguesEspanhol.put("pare", "detener");
        this.dicionarioPortuguesEspanhol.put("e", "y");
        this.dicionarioPortuguesEspanhol.put("vai", "vai");

        StringBuilder fraseFinal = new StringBuilder();
        for(String palavra : palavraPortugues.split(" ")) {
            fraseFinal.append(this.dicionarioPortuguesEspanhol.get(palavra));
            fraseFinal.append(" ");
        }
        return fraseFinal.toString().trim();
    }
}
