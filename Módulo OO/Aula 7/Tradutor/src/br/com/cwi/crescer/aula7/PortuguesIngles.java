package br.com.cwi.crescer.aula7;

import java.util.HashMap;
import java.util.Map;

public class PortuguesIngles {

    private String palavrasPortugues;
    private Map<String, String> dicionarioPortuguesIngles;

    public PortuguesIngles(String palavrasPortugues) {
        this.palavrasPortugues = palavrasPortugues;
    }

    public String getPalavrasPortugues() {
        return palavrasPortugues;
    }

    public Map<String, String> getDicionarioPortuguesIngles() {
        return dicionarioPortuguesIngles;
    }

    public String getTradutorPortuguesIngles() throws NaoHouveTraducaoException{
        this.dicionarioPortuguesIngles = new HashMap<>();
        this.dicionarioPortuguesIngles.put("você","you");
        this.dicionarioPortuguesIngles.put("diz","say");
        this.dicionarioPortuguesIngles.put("sim","yes");
        this.dicionarioPortuguesIngles.put("eu","i");
        this.dicionarioPortuguesIngles.put("digo","say");
        this.dicionarioPortuguesIngles.put("não","no");
        this.dicionarioPortuguesIngles.put("pare","stop");
        this.dicionarioPortuguesIngles.put("e","and");
        this.dicionarioPortuguesIngles.put("vai","go");


        StringBuilder fraseFinal = new StringBuilder();
        for(String palavra : palavrasPortugues.split(" ")) {
            fraseFinal.append(this.dicionarioPortuguesIngles.get(palavra));
            fraseFinal.append(" ");
        }
        return fraseFinal.toString().trim();
    }


}
