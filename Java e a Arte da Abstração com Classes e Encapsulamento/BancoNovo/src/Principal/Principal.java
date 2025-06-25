package Principal;

import java.util.Scanner;

public class Principal {

    Scanner leitura = new Scanner(System.in);

    public void exibirMenu(){
        boolean continuar = true;

        while(continuar){

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

            switch (opcao){
                case 1 ->
                case 2 ->
                case 3 ->
                case 4 ->
                case 5 ->
                case 6 ->
                case 0 -> {
                    System.out.println("Saindo do programa...");
                    continuar = false;
                }
                default -> System.out.println("Opcao invalida!");
            }
        }

    }
}
