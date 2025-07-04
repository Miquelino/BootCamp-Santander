import Model.*;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String mensagem = "Compre na promoção";


        System.out.println(new SMS(mensagem));
        System.out.println(new Email(mensagem));
        System.out.println(new Insta(mensagem));
        System.out.println(new Whats(mensagem));

    }



}