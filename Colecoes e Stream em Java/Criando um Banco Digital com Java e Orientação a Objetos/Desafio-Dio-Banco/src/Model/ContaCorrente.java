package Model;

public class ContaCorrente extends Conta{


    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirStatus() {
        System.out.println("=== Extrato conta corrente ===");
        super.imprimirInfosComuns();
    }
}
