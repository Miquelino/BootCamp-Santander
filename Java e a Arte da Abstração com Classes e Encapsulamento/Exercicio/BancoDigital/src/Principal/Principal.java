package Principal;

import Model.Conta;

import java.util.*;

public class Principal {

    Scanner leitura = new Scanner(System.in);
    private List<Conta> contas = new ArrayList<>(); // Lista para armazenar os objetos Conta
    Conta conta;

    // Bloco de inicialização para criar os 4 objetos Conta
    // Este bloco é executado quando uma instância de Principal é criada
    {
        contas.add(new Conta("Carlos", 27, 1, 1));
        contas.add(new Conta("Ana", 29, 2, 1));
        contas.add(new Conta("Andre", 23, 3, 1));
        contas.add(new Conta("Ariane", 21, 4, 1));
        System.out.println("4 contas de teste criadas em memória."); // Para depuração
    }


    public void exibirMenu() {

        boolean contaContinuar = true;

        while(contaContinuar) {
            boolean continuar = true;
            System.out.println("Deseja entrar na conta? 1 - sim e 2 - nao");
            var entrar = leitura.nextInt();
            if (entrar == 1){
                consultarConta();
                while (continuar) {

                    var menu = """
                        1. Consultar saldo
                        2. consultar cheque especial
                        3. Depositar dinheiro;
                        4. Sacar dinheiro;
                        5. Pagar um boleto.
                        6. Verificar se a conta está usando cheque especial.
                        0. Sair                   
                        """;

                    System.out.println(menu);
                    var opcao = leitura.nextInt();

                    switch (opcao) {
                        case 1 -> consultarSaldo();
                        case 2 -> consultaCheckEspecial();
                        case 3 -> depositar();
                        case 4 -> sacar();
                        case 5 -> pagarBoleto();
                        //case 6 ->
                        case 0 -> {
                            System.out.println("Saindo do programa...");
                            continuar = false;
                        }
                        default -> System.out.println("Opcao invalida!");
                    }
                }
            } else{
                System.out.println("Fechando o programa....");
                contaContinuar = false;
            }
        }
    }

    public void consultarConta(){
        System.out.println("Digite o número da conta: ");

        try {
            var numero = leitura.nextInt();

            Optional<Conta> contaEncotrada = contas.stream()
                    .filter(c -> c.getNumeroConta() == numero)
                    .findAny();

            if (contaEncotrada.isPresent()){
                conta = contaEncotrada.get();
                System.out.println("Seja bem vindo " + conta.getName());
            } else {
                System.out.println("Conta não encontrada. Verifique o número digitado.");
            }
        } catch (InputMismatchException e){
            System.out.println("Entrada inválida. Por favor, digite um NÚMERO inteiro para a conta.");
            leitura.nextLine(); // Consome a entrada inválida
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao consultar o saldo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void consultarSaldo() {

        System.out.println("O saldo da conta é: " + conta.getSaldo());
    }

    public void consultaCheckEspecial(){
        //consultarConta();
        System.out.println("O valor do check especial é " + conta.validaChequeEspecial());
    }

    public void depositar(){
        //consultarConta();
        System.out.println("Deseja depositar quanto?");
        var deposito = leitura.nextDouble();
        conta.setDepositar(deposito);
    }

    public void sacar(){
        //consultarConta();
        System.out.println("Quando deseja sacar?");
        var sacar = leitura.nextDouble();
        conta.setSacar(sacar);
    }

    public void pagarBoleto(){
        //consultarConta();
        System.out.println("Qual o valor do boleto?");
        var pagar = leitura.nextDouble();
        var novoSaldo = conta.getSaldo() - pagar;
        conta.setSaldo(novoSaldo);
    }


}
