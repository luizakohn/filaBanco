package filaBanco;

public class Atendente extends Thread {
    String nome;
    int horaChegada;

    public Atendente(String nome, int horaChegada) {
        this.nome = nome;
        this.horaChegada = horaChegada;
    }

    @Override
    public void run() {
        
    }
}
