package Principal;

import Model.*;


import java.util.List;
import java.util.Scanner;

import static Model.AparelhoTelefonico.*;

public class Principal {

    Scanner leitura = new Scanner(System.in);

    List<Musicas> musicasList = List.of(
            new Musicas(1, "Eu e voc", 2.20),
            new Musicas(2, "So voc", 3.12),
            new Musicas(3, "Cafaeste", 2.15)
    );

    AparelhoTelefonico aparelhoTelefonico = new AparelhoTelefonico();
    NavegadorInternet navegadorInternet = new NavegadorInternet();
    ReprodutorMusical reprodutorMusical = new ReprodutorMusical();

    public void exibirMenu() {
        boolean continuar = true;
        while (continuar){
            var menu = """
                    1. SpotiFy
                    2. Fazer Ligacao
                    3. Abrir internet
                    4. Atender celular
                    5. Correio de Voz
                    0. Bloquear Celular
                    """;
            System.out.println(menu);
            var opcao = leitura.nextInt();
            switch (opcao){
                case 1 -> reprodutorMusical.selecionarMusica();
                case 2 -> fazerLigacao();
                case 3 -> abrirNavegador();
                case 4 -> aparelhoTelefonico.atender();
                case 5 -> aparelhoTelefonico.iniciarCorreioVoz();
                case 0 -> {
                    System.out.println("Bloqueando o celular.");
                    continuar = false;
                }
                default -> System.out.println("Opcao Invalida");
            }
        }
    }

    public void fazerLigacao(){
        System.out.println("Digite o número telefone");
        var numero = leitura.nextInt();
        aparelhoTelefonico.ligar(numero);
    }

    public void abrirNavegador(){
        System.out.println("Digite o site: ");
        var site = leitura.next();
        navegadorInternet.exibirPagina(site);
        var menu = """
                1. Abrir nova ABA
                2. Atualizar página
                3. Fechar página
                """;
        System.out.println(menu);
        var menuPagina = leitura.nextInt();
        if (menuPagina == 1){
            navegadorInternet.adicionarNovaAba();
        } else if (menuPagina == 2){
            navegadorInternet.atualizarPagina();
        } else if (menuPagina == 3){
            navegadorInternet.fecharPagina();
        }
    }

}
