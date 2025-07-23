package Principal;

import Model.Carro;

import java.util.Scanner;

public class Principal {
    Scanner leitura = new Scanner(System.in);
    Carro carro = new Carro();

    public void exibirMenu(){
        boolean continuar = true;

        while (continuar) {

            var menu = """
                    1. Ligar carro
                    2. Desligar carro
                    3. Acelerar
                    4. Diminuir velocidade
                    5. virar para esquerda/direita
                    6. verificar velocidade
                    7. trocar a marcha
                    0. Sair
                    """;

            System.out.println(menu);
            var opcao = leitura.nextInt();

            switch (opcao){
                case 1 -> ligarCarro();
                case 2 -> desligarCarro();
                case 3 -> acelerarCarro();
                case 4 -> diminuirVelocidade();
                case 5 -> virarDirecao();
                case 6 -> System.out.println("O carro estava a " + carro.getVelocidade() + "KM por hora");
                case 7 -> trocarMarcha();
                case 0 -> {
                    System.out.println("Saindo do programa...");
                    continuar = false;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    public void ligarCarro(){
        System.out.println("Ligando o carro.");
        carro.setLigar(true);
    }

    public void desligarCarro(){
        if (carro.isLigar() != false){
            System.out.println("Desligando o carro...");
            carro.isLigar();
        } else {
            System.out.println("O carro já esta desligado");
        }
    }
    public void acelerarCarro(){
        if (carro.getVelocidade() == 0) {
            if (carro.getMarcha() == 0){
                System.out.println("O carro está no neutro, favor trocar para primeira marcha");
            } else {
                System.out.println("Acelerando o carro.");
                carro.setVelocidade(20);
            }
        } else {
            System.out.println("O carro está a " + carro.getVelocidade() + "KM por hora");
            carro.setVelocidade(20);
            if (carro.getVelocidade() < 20){
                System.out.println("Favor trocar para primeira marcha");
            } else if (carro.getVelocidade() < 40){
                System.out.println("Favor trocar para segunda marcha");
            } else if (carro.getVelocidade() < 60){
                System.out.println("Favor trocar para terceira marcha");
            } else if (carro.getVelocidade() < 80){
                System.out.println("Favor trocar para quarta marcha");
            } else if (carro.getVelocidade() < 100){
                System.out.println("Favor trocar para quinta marcha");
            } else if (carro.getVelocidade() < 120){
                System.out.println("Favor trocar para sexta marcha");
            }
        }
    }

    private void diminuirVelocidade() {
        if (carro.getVelocidade() < 0) {
            System.out.println("Carro já esta parado");
        } else {
            System.out.println("O carro estava a " + carro.getVelocidade() + "KM por hora");
            carro.setVelocidade(-20);
            System.out.println("Agora está á " + carro.getVelocidade() + "KM por hora");
        }
    }

    private void virarDirecao() {
        System.out.println("Deseja virar para qual direção? Direita e Esquerda");
        var direcao = leitura.nextInt();
        System.out.println("O carro foi virado para a " + direcao);
    }

    private void trocarMarcha() {
        System.out.println("Trocando de marcha...");
        carro.setMarcha(+1);
    }
}
