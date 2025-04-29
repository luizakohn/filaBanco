package filaBanco;

public class Cliente extends Thread {
    int horaChegada;
    String nome;
    int horaAtendimento;
    int tempoAtendimento;
    
    public Cliente(int horaChegada, String nome) {
        this.horaChegada = horaChegada;
        this.nome = nome;
    }
}

