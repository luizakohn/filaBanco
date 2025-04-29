package filaBanco;

public class Cliente {
    int horaChegada;
    String nome;
    int tempoAtendimento;
    int horaInicioAtendimento = -1; // Inicializado como -1 para indicar que ainda não foi atendido
    int horaSaida = -1; // Inicializado como -1 para indicar que ainda não saiu

    public Cliente(int horaChegada, String nome, int tempoAtendimento) {
        this.horaChegada = horaChegada;
        this.nome = nome;
        this.tempoAtendimento = tempoAtendimento;
    }

    public void iniciarAtendimento(int horaInicio) {
        this.horaInicioAtendimento = horaInicio;
    }

    public void finalizarAtendimento(int horaSaida) {
        this.horaSaida = horaSaida;
    }
}

