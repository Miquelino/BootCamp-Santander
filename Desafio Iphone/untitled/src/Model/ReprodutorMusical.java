package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReprodutorMusical {

    Scanner leitura = new Scanner(System.in);
    private boolean tocando = false;

    List<Musicas> musicasList = List.of(
            new Musicas(1, "Eu e voc", 2.20),
            new Musicas(2, "So voc", 3.12),
            new Musicas(3, "Cafaeste", 2.15)
    );

    public static void tocar(int musica){
        System.out.println("Tocando a música: " + musica);
    }

    public void pausar(){
        if(this.tocando){
            System.out.println("Pausando a musica");
            this.tocando = false;
        }
    }

    public void selecionarMusica(){
        System.out.println("Selecione a música");
        musicasList.forEach(m -> System.out.println(m.getId() + "Musica: " + m.getNome()));
        var selecionarMusica = leitura.nextInt();
        Musicas musicaSelecionada = musicasList.stream()
                .filter(m -> m.getId() == selecionarMusica)
                .findFirst()
                .orElse(null);
        if (musicaSelecionada != null){
            ReprodutorMusical.tocar(musicaSelecionada.getId());
        } else {
            System.out.println("Música não encontrada!");
        }
        System.out.println("Deseja pausar a musica? 1 = sim e 2 = não");
        var pausarMusica = leitura.nextInt();
        if (pausarMusica == 1){
            pausar();
        }
    }

    public boolean isTocando() {
        return tocando;
    }

    public void setTocando(boolean tocando) {
        this.tocando = tocando;
    }


}
