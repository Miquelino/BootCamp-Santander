package Model;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirStatus() {
        System.out.println("=== Extrato conta poupanca ===");
        super.imprimirInfosComuns();
    }
}
