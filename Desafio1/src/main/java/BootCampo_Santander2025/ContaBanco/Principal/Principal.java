package BootCampo_Santander2025.ContaBanco.Principal;

import BootCampo_Santander2025.ContaBanco.Entities.Banco;
import BootCampo_Santander2025.ContaBanco.Entities.Conta;
import BootCampo_Santander2025.ContaBanco.Entities.Usuario;

import java.util.Scanner;

public class Principal {

    Scanner leitura = new Scanner(System.in);


    Usuario usuario1 = new Usuario("Mario Andrade", 27, "Andrade@Dio.com", "Araraquara");
    Banco santander = new Banco("Santander");
    Conta conta1 = new Conta(1021, "067-8");


    public void exibirMenu(){
        boolean continuar = true;
        conta1.setSaldo(237.48);
        conta1.setTitular(usuario1);
        conta1.setBanco(santander);
        System.out.println("Seja bem vindo!");
        System.out.println("Digite sua conta: ");
        var conta = leitura.nextInt();
        if (conta == conta1.getNumero()){
            conta1.exibirInformacoes();

            while(continuar){
                var menu = """
                        1 - Saldo
                        2 - Depositar
                        3 - Sacar
                        0 - Sair
                        """;

                System.out.println(menu);
                var opcao = leitura.nextInt();

                switch (opcao){
                    case 1:
                        System.out.println(conta1.getSaldo());
                        break;

                    case 2:
                        System.out.println("Quanto deseja depositar?");
                        var depositar = leitura.nextDouble();
                        conta1.depositar(depositar);
                        System.out.println("Seu saldo é: " + conta1.getSaldo());
                        break;

                    case 3:
                        System.out.println("Quanto deseja sacar?");
                        var sacar = leitura.nextDouble();
                        conta1.sacar(sacar);
                        System.out.println("Seu saldo é: " + conta1.getSaldo());
                        break;

                    case 0:
                        System.out.println("Saindo da conta...");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opção inválda!");
                        break;
                }
            }


        } else {
            System.out.println("Conta não encontrada");
        }
    }
}
