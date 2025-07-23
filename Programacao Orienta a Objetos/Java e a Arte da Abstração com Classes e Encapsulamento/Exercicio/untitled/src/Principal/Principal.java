package Principal;

import Model.Pet;
import Model.PetMachine;

import java.util.Scanner;

public class Principal {

    private static final Scanner leitura = new Scanner(System.in);

    static PetMachine petMachine = new PetMachine();
    static Pet pet;


    public void exibir(){
        leitura.useDelimiter("\\n");
        boolean continuar = true;

        while (continuar){
            var menu = """
                Escolha uma opção
                --------------------
                1. Dar banho no pet
                2. Abastecer maquina com agua
                3. Abastecer maquina com shampoo
                4. Verificar agua na maquina
                5. Verificar shampoo na maquina
                6. Verificar se tem pet o banho
                7. Colocar pet na maquina
                8. Retirar pet  da maquina
                9. Limpar maquina
                0. Sair
                """;

            System.out.println(menu);
            var opcao = leitura.nextInt();

            switch (opcao) {
                case 1 -> petMachine.takeAShower();
                case 2 -> setWater();
                case 3 -> setShampoo();
                case 4 -> verifyWater();
                case 5 -> verifyShampoo();
                case 6 -> checkIfHasPetInMachine();
                case 7 -> setPetInSetMachine();
                case 8 -> petMachine.removePet();
                case 9 -> petMachine.wash();
                case 0 -> {
                    System.out.println("Saindo do programa");
                    continuar = false;
                }
                default -> System.out.println("Opção " + opcao + " invalida!");


            }
        }
    }

    public static void setWater(){
        System.out.println("Tentando colocar agua a maquina");
        petMachine.addWater();
    }

    public static void setShampoo(){
        System.out.println("Tentando colocar shampoo a maquina");
        petMachine.addShampoo();
    }

    public static void verifyWater(){
        var amount = petMachine.getShampoo();
        System.out.println("A maquina esta no momento com " + amount +  " litro(s) de water");
    }

    public static void verifyShampoo(){
        var amount = petMachine.getShampoo();
        System.out.println("A maquina esta no momento com " + amount +  " litro(s) de shampoo");
    }

    public static void checkIfHasPetInMachine(){
        var hasPet = petMachine.hasPet();
        System.out.println(hasPet ? "Tem pet na maquia" : "Nao tem pet na maquia.");
    }

    public static void setPetInSetMachine() {
        var name = "";
        while (name == null || name.isEmpty()){
            System.out.println("Informa o nome do pet: ");
            name = leitura.next();
        }
        pet = new Pet(name);
        petMachine.setPet(pet);

    }

    public void getPetFromMachine(){

    }
}
