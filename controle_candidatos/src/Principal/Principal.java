package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class processoSeletivo {

    public processoSeletivo() {
    }

    public void exibirMenu() {
        imprimirSelecionados();
    }

    public void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra porposta");
        } else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }

    public void imprimirSelecionados() {
        String[] candidatos = {"Felipe", "Marcia", "Andre", "Ariane", "Joao", "Ana", "Fabio", "Julia", "Carlos", "Bea"};
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("O candidato de n " + (i + 1) + " é o " + candidatos[i]);
        }

        System.out.println("Forma abreviada");
        for (String candidato : candidatos) {
            System.out.println("O candidato selecioando foi: " + candidato);
        }
    }

    public void selecaoCandidatos() {
        String[] candidatos = {"Felipe", "Marcia", "Andre", "Ariane", "Joao", "Ana", "Fabio", "Julia", "Carlos", "Bea"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salario " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato  " + candidato + " foi selecionado para vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void entrandoEmCotato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso!");
            }
        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato);
        } else {
            System.out.println("Não conseguimos cobtato");
        }
    }

}
