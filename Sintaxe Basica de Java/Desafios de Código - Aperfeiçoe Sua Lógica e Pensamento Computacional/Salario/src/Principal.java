import java.util.Scanner;

public class Principal {

    Scanner leitura = new Scanner(System.in);

    public Principal() {
    }

    public void exibirExercicio() {
        // Le os valores do salario e beneficio
        System.out.println("Insira o valor do salário: ");
        var valorSalario = leitura.nextDouble();
        System.out.println("Insira o valor do beneficio: ");
        var valorBeneficio = leitura.nextDouble();

        double valorImposto = 0;
        if (valorSalario >= 0 && valorSalario <= 1100) {
            // Atribui a aliquota de 5% mediante o salário
            valorImposto = 0.5F * valorSalario;
        } else if (valorSalario >= 1100.01 && valorSalario <= 2500.00) {

            valorImposto = 0.10F * valorSalario;
        } else if (valorSalario >= 2500.00) {
            valorImposto = 0.15F * valorSalario;
        } else {
            System.out.println("Valores inseridos negativo!");
        }

        // Calcula e imprime a saída (com 2 casas decimais)
    double saida = valorSalario - valorImposto + valorBeneficio;
        System.out.println(String.format("%2f", saida));
    }
}
