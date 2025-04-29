package filaBanco;

import java.util.ArrayList;
import java.util.List;

public class Fila {
    List<Cliente> fila = new ArrayList<>();

    public synchronized void adicionarCliente(Cliente cliente) {
        fila.add(cliente);
    }
    public synchronized Cliente removerCliente() {
        if (fila.isEmpty()) {
            return null;
        } else {
            return fila.remove(0);
        }
    } 
}
