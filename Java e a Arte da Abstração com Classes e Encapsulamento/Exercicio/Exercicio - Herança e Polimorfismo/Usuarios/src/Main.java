import Model.Atendente;
import Model.Gerente;
import Model.Usuario;
import Model.Vendedor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        Usuario gerente = new Gerente("123", "Carlos", "gerente@email");
        Usuario vendedor1 = new Vendedor("123", "Andre", "vendedor@email", 5);
        Usuario atendente1 = new Atendente("123", "Junior", "junior@email", 500.30);

        menu((Gerente) gerente, (Vendedor) vendedor1, (Atendente) atendente1);
    }

    public static void menu(Gerente gerente, Vendedor vendedor1, Atendente atendente1){

        Scanner leitura = new Scanner(System.in);

        var menu = """
                1. Gerente
                2. Vendedor
                3. Atendente
                4. Sair
                """;

        System.out.println(menu);

        var opcao = leitura.nextInt();
        boolean continuar = true;
        while(continuar){
            switch (opcao){
                case 1 -> gerente.exibirMenuGerente();
                case 2 -> vendedor1.exibirMenuVendedor();
                case 3 -> atendente1.exibirMenuAtendente();
                case 4 ->  continuar = false;
                default -> throw new IllegalStateException("Unexpected value: " + opcao);
            }
        }
    }
}