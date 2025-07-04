import Model.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        var produto = 64;

        System.out.println(new Alimentacao(produto, 0.01).tributo());
        System.out.println(new Saude(produto, 0.015).tributo());
        System.out.println(new Vestuario(produto, 0.025).tributo());
        System.out.println(new Cultura(produto, 0.04).tributo());
    }
}