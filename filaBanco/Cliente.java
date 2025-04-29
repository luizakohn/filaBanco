package filaBanco;

public class Cliente extends Thread {
    int horaChegada;
    String nome;
    int horaAtendimento;
    int tempoAtendimento;
    
    public Cliente(int horaChegada, String nome, int tempoAtendimento) {
        this.horaChegada = horaChegada;
        this.nome = nome;
        this.tempoAtendimento = tempoAtendimento;
    }
}

