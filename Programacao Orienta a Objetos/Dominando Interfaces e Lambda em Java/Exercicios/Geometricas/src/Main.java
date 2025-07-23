import Model.Circle;
import Model.Rectangle;
import Model.Square;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        var leitura = new Scanner(System.in);

        boolean seguir = true;
        while (seguir){

            var menu = """
                    Escolha a forma geométrica para calcular a area
                    1. Quadrado
                    2. Retrangulo
                    3. Circulo
                    4. Sair
                    """;

            System.out.println(menu);
            var option = leitura.nextInt();

            switch (option){
                case 1 -> {
                    System.out.println("Informe o tamanho do quadrado");
                    var side = leitura.nextDouble();
                    System.out.println(new Square(side).getArea());
                }
                case 2 -> {
                    System.out.println("Informe a base: ");
                    var base = leitura.nextDouble();
                    System.out.println("Informe a altura: ");
                    var height = leitura.nextDouble();
                    System.out.println(new Rectangle(height, base).getArea());
                }
                case 3 -> {
                    System.out.println("Informe o radius: ");
                    var radius = leitura.nextDouble();
                    System.out.println(new Circle(radius).getArea());
                }
                case 4 -> seguir = false;

                default -> throw new IllegalAccessError("Opcao invalida!");
            }
        }

    }


}