package Principal;

import Exception.ParametrosInvalidosException;
import java.util.Scanner;

public class Principal {

    Scanner leitura = new Scanner(System.in);

    public Principal() {
    }

    public void exibirMenu() {
        System.out.println("Digite o primeiro número: ");
        var numeroUm = leitura.nextInt();
        System.out.println("Digite o segundo número: ");
        var numeroDois = leitura.nextInt();

        try {
            contar(numeroUm, numeroDois);
        } catch (ParametrosInvalidosException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    static void contar(int numeroUm, int numeroDois) {
        if (numeroUm >= numeroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int contagem = numeroDois - numeroUm;

        System.out.println("\nIniciando contagem:");
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
        System.out.println("\nContagem finalizada. Total de interações: " + contagem);

    }
}

