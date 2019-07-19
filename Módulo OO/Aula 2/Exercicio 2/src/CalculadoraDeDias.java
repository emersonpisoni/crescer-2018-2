public class CalculadoraDeDias {

    public String segundosParaDias(int segundos) {

        int dias = 0;
        int horas = 0;
        int minutos = 0;
        int resto = 0;

        dias = segundos / 86400;
        resto = segundos % 86400;
        horas = resto / 3600;
        resto = resto % 3600;
        minutos = resto / 60;
        segundos = resto % 60;

        return String.format("%02d", dias) + " dias " + String.format("%02d", horas) + ":" + String.format("%02d",minutos) + ":" + String.format("%02d", segundos);
    }
}
