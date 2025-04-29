package filaBanco;

public class Atendente {
    private String nome;
    private Cliente clienteAtual;
    private int tempoFimAtendimento;

    public Atendente(String nome) {
        this.nome = nome;
        this.clienteAtual = null;
        this.tempoFimAtendimento = 0;
    }

    public boolean estaOcupado() {
        return clienteAtual != null;
    }

    public void atenderCliente(Cliente cliente, int tempoAtual) {
        this.clienteAtual = cliente;
        this.tempoFimAtendimento = tempoAtual + cliente.tempoAtendimento;
        cliente.iniciarAtendimento(tempoAtual); // Atualiza o tempo de início do atendimento
        System.out.println(nome + " começou a atender " + cliente.nome + " às " + tempoAtual + " segundos.");
    }

    public void avancarTempo(int tempoAtual) {
        if (clienteAtual != null && tempoAtual >= tempoFimAtendimento) {
            clienteAtual.finalizarAtendimento(tempoAtual); // Atualiza o tempo de saída do cliente
            System.out.println(nome + " finalizou o atendimento de " + clienteAtual.nome + " às " + tempoAtual + " segundos.");
            clienteAtual = null;
        }
    }
}
