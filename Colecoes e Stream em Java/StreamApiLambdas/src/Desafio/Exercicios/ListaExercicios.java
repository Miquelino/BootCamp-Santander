package Desafio.Exercicios;

import StreamAPI.ConsumerExample;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListaExercicios {

    Scanner leitura = new Scanner(System.in);
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

    public void exibirListaExercicio(){
        boolean continuar = true;
        while (continuar){
            var menu = """
                    Selecione o exercicio
                    1. 2. 3. 4. 5. 6. 7. 8. 6. 10. 11. 12. 13. 14. 15. 16. 17. 18. 19.
                    0. Sair
                    """;

            System.out.println(menu);
            var opcao = leitura.nextInt();

            switch (opcao){
                case 1 -> exercicio1();
                case 2 -> exercicio2();
                case 3 -> exercicio3();
                case 4 -> exercicio4();
                case 5 -> exercicio5();
                case 6 -> exercicio6();
                case 7 -> exercicio7();
                case 8 -> exercicio8();
                case 9 -> exercicio9();
                case 10 -> exercicio10();
                case 11 -> exercicio11();
                case 12 -> exercicio12();
                case 13 -> exercicio13();
                case 14 -> exercicio14();
                case 15 -> exercicio15();
                case 16 -> exercicio16();
                case 17 -> exercicio17();
                case 18 -> exercicio18();
                case 19 -> exercicio19();
                case 0 -> {
                    System.out.println("Saindo do programa.");
                    continuar = false;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void exercicio1(){
        System.out.println("Desafio 1 - Mostre a lista na ordem numérica:\n" +
                "Crie um programa que utilize a Stream API para ordenar a lista de números em ordem crescente e a exiba no console.");
        numeros.stream().sorted().forEach(System.out::println);
    }

    private void exercicio2(){
        System.out.println("Desafio 2 - Imprima a soma dos números pares da lista:\n" +
                "Utilizando a Stream API, realize a soma dos números pares da lista e exiba o resultado no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        numeros.stream()
                .filter(n -> n % 2 == 0)
                .sorted()
                .forEach(System.out::println);

        int somaPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Soma dos números pares: " + somaPares);
        }

    private void exercicio3(){
        System.out.println("Desafio 3 - Verifique se todos os números da lista são positivos:\n" +
                "Com a ajuda da Stream API, verifique se todos os números da lista são positivos e exiba o resultado no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        List<Integer> numerosPositivos = numeros.stream().filter(n -> n > 0).toList();

        System.out.println("Números positivos: " + numerosPositivos);
    }

    private void exercicio4(){
        System.out.println("Desafio 4 - Remova todos os valores ímpares:\n" +
                "Utilize a Stream API para remover os valores ímpares da lista e imprima a lista resultante no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        numeros.stream()
                .filter(n -> n % 2 == 0)
                .sorted()
                .forEach(System.out::println);
    }

    private void exercicio5(){
        System.out.println("Desafio 5 - Calcule a média dos números maiores que 5:\n" +
                "Com a Stream API, calcule a média dos números maiores que 5 e exiba o resultado no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println("Lista sem números ímpares: " + pares);
    }

    private void exercicio6(){
        System.out.println("Desafio 6 - Verificar se a lista contém algum número maior que 10:\n" +
                "Utilize a Stream API para verificar se a lista contém algum número maior que 10 e exiba o resultado no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        numeros.stream().filter(n -> n > 10)
                .toList()
                .forEach(System.out::println);
    }

    private void exercicio7(){
        System.out.println("Desafio 7 - Encontrar o segundo número maior da lista:\n" +
                "Com a ajuda da Stream API, encontre o segundo número maior da lista e exiba o resultado no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        Optional<Integer> segundoMaior = numeros.stream()
                .distinct() // remove duplicatas
                .sorted(Comparator.reverseOrder()) // ordena do maior para o menor
                .skip(1) // pula o primeiro (maior)
                .findFirst(); // pega o segundo maior

        if (segundoMaior.isPresent()) {
            System.out.println("Segundo maior número: " + segundoMaior.get());
        } else {
            System.out.println("Não foi possível encontrar o segundo maior número.");
        }
    }

    private void exercicio8(){
        System.out.println("Desafio 8 - Somar os dígitos de todos os números da lista:\n" +
                "Utilizando a Stream API, realize a soma dos dígitos de todos os números da lista e exiba o resultado no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        int somaDosDigitos = numeros.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Soma dos dígitos: " + somaDosDigitos);
    }

    private void exercicio9(){
        System.out.println("Desafio 9 - Verificar se todos os números da lista são distintos (não se repetem):\n" +
                "Com a Stream API, verifique se todos os números da lista são distintos (não se repetem) e exiba o resultado no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        boolean todosDistintos = numeros.stream()
                .allMatch(new HashSet<>()::add); // adiciona no Set, retorna false se já existir

        System.out.println("Todos os números são distintos? " + todosDistintos);
    }

    private void exercicio10(){
        System.out.println("Desafio 10 - Agrupe os valores ímpares múltiplos de 3 ou de 5:\n" +
                "Utilize a Stream API para agrupar os valores ímpares múltiplos de 3 ou de 5 e exiba o resultado no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        List<Integer> resultado = numeros.stream()
                .filter(n -> n % 2 != 0) // apenas ímpares
                .filter(n -> n % 3 == 0 || n % 5 == 0) // múltiplos de 3 ou 5
                .toList();

        System.out.println("Valores ímpares múltiplos de 3 ou 5: " + resultado);
    }

    private void exercicio11(){
        System.out.println("Desafio 11 - Encontre a soma dos quadrados de todos os números da lista:\n" +
                "Utilizando a Stream API, encontre a soma dos quadrados de todos os números da lista e exiba o resultado no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        int somaDosQuadrados = numeros.stream()
                .mapToInt(n -> n * n) // eleva cada número ao quadrado
                .sum(); // soma todos os quadrados

        System.out.println("Soma dos quadrados: " + somaDosQuadrados);
    }

    private void exercicio12(){
        System.out.println("Desafio 12 - Encontre o produto de todos os números da lista:\n" +
                "Com a ajuda da Stream API, encontre o produto de todos os números da lista e exiba o resultado no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        int produto = numeros.stream()
                .reduce(1, (a, b) -> a * b); // multiplica todos os elementos

        System.out.println("Produto de todos os números: " + produto);
    }

    private void exercicio13(){
        System.out.println("Desafio 13 - Filtrar os números que estão dentro de um intervalo:\n" +
                "Utilize a Stream API para filtrar os números que estão dentro de um intervalo específico (por exemplo, entre 5 e 10) e exiba o resultado no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        int minimo = 5;
        int maximo = 10;

        List<Integer> dentroDoIntervalo = numeros.stream()
                .filter(n -> n >= minimo && n <= maximo)
                .collect(Collectors.toList());

        System.out.println("Números entre " + minimo + " e " + maximo + ": " + dentroDoIntervalo);
    }

    private void exercicio14(){
        System.out.println("Desafio 14 - Encontre o maior número primo da lista:\n" +
                "Com a Stream API, encontre o maior número primo da lista e exiba o resultado no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        Optional<Integer> maiorPrimo = numeros.stream()
                .filter(ListaExercicios::ehPrimo)
                .max(Integer::compareTo);

        if (maiorPrimo.isPresent()) {
            System.out.println("Maior número primo: " + maiorPrimo.get());
        } else {
            System.out.println("Nenhum número primo encontrado na lista.");
        }
    }

    private void exercicio15(){
        System.out.println("Desafio 15 - Verifique se a lista contém pelo menos um número negativo:\n" +
                "Utilizando a Stream API, verifique se a lista contém pelo menos um número negativo e exiba o resultado no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        boolean contemNegativo = numeros.stream()
                .anyMatch(n -> n < 0);

        System.out.println("A lista contém número(s) negativo(s)? " + contemNegativo);
    }

    private void exercicio16(){
        System.out.println("Desafio 16 - Agrupe os números em pares e ímpares:\n" +
                "Utilize a Stream API para agrupar os números em duas listas separadas, " +
                "uma contendo os números pares e outra contendo os números ímpares da lista original, e exiba os resultados no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        Map<Boolean, List<Integer>> agrupados = numeros.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Números pares: " + agrupados.get(true));
        System.out.println("Números ímpares: " + agrupados.get(false));
    }

    private void exercicio17(){
        System.out.println("Desafio 17 - Filtrar os números primos da lista:\n" +
                "Com a ajuda da Stream API, filtre os números primos da lista e exiba o resultado no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();


        List<Integer> primos = numeros.stream()
                .filter(ListaExercicios::ehPrimo)
                .toList();

        System.out.println("Números primos: " + primos);
    }

    private void exercicio18(){
        System.out.println("Desafio 18 - Verifique se todos os números da lista são iguais:\n" +
                "Utilizando a Stream API, verifique se todos os números da lista são iguais e exiba o resultado no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        boolean todosIguais = numeros.stream()
                .allMatch(n -> n.equals(numeros.get(0))); // verifica se todos são iguais ao primeiro

        System.out.println("Todos os números são iguais? " + todosIguais);
    }

    private void exercicio19(){
        System.out.println("Desafio 19 - Encontre a soma dos números divisíveis por 3 e 5:\n" +
                "Com a Stream API, encontre a soma dos números da lista que são divisíveis tanto por 3 quanto por 5 e exiba o resultado no console.");

        System.out.println("Lista de números: " + numeros);
        System.out.println();

        int soma = numeros.stream()
                .filter(n -> n % 3 == 0 && n % 5 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Soma dos números divisíveis por 3 e 5: " + soma);
    }

    // Função auxiliar para verificar se um número é primo
    private static boolean ehPrimo(int numero) {
        if (numero < 2) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }
}
