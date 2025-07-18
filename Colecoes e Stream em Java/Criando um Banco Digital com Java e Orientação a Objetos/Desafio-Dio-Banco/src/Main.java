import Model.Cliente;
import Model.Conta;
import Model.ContaCorrente;
import Model.ContaPoupanca;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Cliente reynaldo = new Cliente();
        reynaldo.setNome("reynaldo");

        Conta conta1 = new ContaCorrente(venilton);
//        Conta conta2 = new ContaPoupanca(venilton);

        Conta conta3 = new ContaCorrente(reynaldo);

        conta3.depositar(100);
        //conta3.sacar(100);
        conta3.transferir(100, conta1);

        conta3.imprimirStatus();
//        conta1.depositar(100);
//        conta1.transferir(100, conta2);
//
//        conta1.imprimirStatus();
//        conta2.imprimirStatus();
    }
}