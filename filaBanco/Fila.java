package filaBanco;

import java.util.ArrayList;
import java.util.List;

public class Fila {
    private List<Cliente> fila = new ArrayList<>();
    private List<Cliente> atendidos = new ArrayList<>();
    private List<Cliente> clientesPendentes = new ArrayList<>();

    public synchronized void adicionarCliente(Cliente cliente) {
        clientesPendentes.add(cliente);
    }

    public synchronized void atualizarFila(int tempoAtual) {
        // Adiciona clientes que chegaram no tempo atual à fila
        clientesPendentes.removeIf(cliente -> {
            if (cliente.horaChegada <= tempoAtual) {
                fila.add(cliente);
                return true;
            }
            return false;
        });
    }

    public synchronized Cliente removerCliente() {
        if (fila.isEmpty()) {
            return null;
        } else {
            return fila.remove(0);
        }
    }

    public synchronized void registrarAtendimento(Cliente cliente) {
        atendidos.add(cliente);
    }

    public void gerarEstatisticas() {
        int totalClientes = atendidos.size();
        int tempoMaximoEspera = 0;
        int tempoMaximoAtendimento = 0;
        int tempoTotalBanco = 0;
        int tempoTotalEspera = 0;

        for (Cliente cliente : atendidos) {
            int tempoEspera = cliente.horaInicioAtendimento - cliente.horaChegada;
            int tempoBanco = cliente.horaSaida - cliente.horaChegada;

            tempoMaximoEspera = Math.max(tempoMaximoEspera, tempoEspera);
            tempoMaximoAtendimento = Math.max(tempoMaximoAtendimento, cliente.tempoAtendimento);
            tempoTotalBanco += tempoBanco;
            tempoTotalEspera += tempoEspera;
        }

        double tempoMedioBanco = totalClientes > 0 ? (double) tempoTotalBanco / totalClientes : 0;
        double tempoMedioEspera = totalClientes > 0 ? (double) tempoTotalEspera / totalClientes : 0;

        System.out.println("Clientes atendidos: " + totalClientes);
        System.out.println("Tempo máximo de espera: " + tempoMaximoEspera + " segundos");
        System.out.println("Tempo máximo de atendimento: " + tempoMaximoAtendimento + " segundos");
        System.out.println("Tempo médio no banco: " + tempoMedioBanco + " segundos");
        System.out.println("Tempo médio de espera: " + tempoMedioEspera + " segundos");
        System.out.println("Objetivo atingido (espera <= 120 segundos): " + (tempoMedioEspera <= 120));
    }
}
