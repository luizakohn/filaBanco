package filaBanco;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Cliente> listClientes = criarClientes();
        Atendente[] atendentes = new Atendente[2];
        for (int i = 0; i < atendentes.length; i++) {
            atendentes[i] = new Atendente("Atendente " + (i+1), 0);
            atendentes[i].start();
        }
        System.out.println("Total de clientes: " + listClientes.size());
    }

    private static List<Cliente> criarClientes(){
        Random rand = new Random();
        List<Cliente> listClientes = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < 7200 ;) {
            int tempoChegada = rand.nextInt(46) + 5; 
            int tempoAtendimento = rand.nextInt(130); 
            i += tempoChegada;
            count++;
            listClientes.add(new Cliente(i, "Cliente "+count, tempoAtendimento));
            System.out.println("Cliente " + count + " chegou na hora: " + i + " com tempo de atendimento: " + tempoAtendimento);
            System.out.println("i:" +i);
            
        }
        return listClientes;
    }
}


