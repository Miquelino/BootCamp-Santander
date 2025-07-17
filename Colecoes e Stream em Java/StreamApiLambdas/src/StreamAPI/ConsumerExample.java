package StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    /**
     * Representa uma operação que aceita um argumento do tipo T e não retorna nenhum resultado.
     * É utilizado principalmente para realizar ações, ou efeitos colaterais nos elementos do Stream sem modificar, ou retornar um valor
     */


    public void exibirConsumerExample(){
        // Criar uma lista de números inteiros
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 8);

        // Usar o Consumer com expressão lambda para imprimir números pares
        Consumer<Integer> imprimirNumeroPar = numero -> {
            if (numero % 2 == 0){
                System.out.println(numero);
            }
        };

        // Usar o Consumer para imprimir números pares no Stream
        numeros.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
    }
}
