package Model;

import java.util.Scanner;

public class AparelhoTelefonico {
    Scanner leitura = new Scanner(System.in);
    private boolean ligando = false;

    public void ligar(int numero){
        if (!this.ligando){
            System.out.println("Ligando para " + numero);
            this.ligando = true;
        } else {
            System.out.println("Numero esta indisponivel");
        }
    }

    public void atender(){
        System.out.println("Atendendo telefone");
    }

    public boolean desligar(){
        if (this.ligando){
            System.out.println("Desligando ligação");
            return false;
        } else {
            System.out.println("Telefone desligado");
            return true;
        }
    }

    public String iniciarCorreioVoz(){
        System.out.println("Digite o correio de voz desejado: ");
        return leitura.next();
    }


    public boolean isLigando() {
        return ligando;
    }

    public void setLigando(boolean ligando) {
        this.ligando = ligando;
    }
}
