package cs20162.aula07;

public class DiaDaSemana {

    public int diaSemana(int dataDesejada, int anoBissexto, int dataConhecida,
            int diaSemana) {

        if (!verificaData(dataDesejada) || !verificaData(dataConhecida)) {
            return -1;
        }
        
        
    }

    //Método que verifica a data recebida
    public boolean verificaData(int dataRecebida) {

        String data = Integer.toString(dataRecebida);

        if (data.length() != 8) {
            return true;
        } else {
            return false;
        }
    }
}
