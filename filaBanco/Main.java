package filaBanco;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] numAtendentes = {2}; // Testar com diferentes números de atendentes

        for (int n : numAtendentes) {
            System.out.println("\nSimulação com " + n + " atendente(s):");
            rodarSimulacao(n);
        }
    }

    private static void rodarSimulacao(int numAtendentes) {
        List<Cliente> listClientes = criarClientes();
        Fila fila = new Fila();

        // Adiciona todos os clientes na fila
        for (Cliente cliente : listClientes) {
            fila.adicionarCliente(cliente);
        }

        // Cria os atendentes
        Atendente[] atendentes = new Atendente[numAtendentes];
        for (int i = 0; i < atendentes.length; i++) {
            atendentes[i] = new Atendente("Atendente " + (i + 1));
        }

        // Simula o relógio virtual
        for (int tempoAtual = 0; tempoAtual <= 7200; tempoAtual++) {
            // Verifica se há clientes chegando no tempo atual
            fila.atualizarFila(tempoAtual);

            // Atendentes verificam se podem atender clientes
            for (Atendente atendente : atendentes) {
                if (!atendente.estaOcupado()) {
                    Cliente cliente = fila.removerCliente();
                    if (cliente != null) {
                        atendente.atenderCliente(cliente, tempoAtual);
                    }
                }
                atendente.avancarTempo(tempoAtual);
            }
        }

        // Coleta e exibe os dados estatísticos
        fila.gerarEstatisticas();
    }

    private static List<Cliente> criarClientes() {
        Random rand = new Random();
        List<Cliente> listClientes = new ArrayList<>();
        int count = 0;
        int tempoAtual = 0;

        while (tempoAtual < 7200) { // Simula 2 horas (7200 segundos)
            int tempoChegada = rand.nextInt(46) + 5; // Intervalo entre 5 e 50 segundos
            int tempoAtendimento = rand.nextInt(91) + 30; // Atendimento entre 30 e 120 segundos
            tempoAtual += tempoChegada;
            count++;
            listClientes.add(new Cliente(tempoAtual, "Cliente " + count, tempoAtendimento));
        }

        return listClientes;
    }
}


