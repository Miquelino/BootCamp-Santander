package deBugAula;

import deBugAula.Model.MenuOption;
import deBugAula.Model.UserModel;
import deBugAula.dao.UserModelDao;
import deBugAula.exception.CustomException;
import deBugAula.exception.EmptyStoregeException;
import deBugAula.exception.UserNotFoundExeption;
import deBugAula.exception.ValidatorException;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static deBugAula.validator.UserValidator.VerifyModel;

public class Main {

    private final static UserModel dao = new UserModel();
    private final static Scanner leitura = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Bem vindo ao cadastro de usuário.");
            var menu = """
                    1 - Cadastrar
                    2 - Atualizar
                    3 - Excluir
                    4 - Buscar por identificador
                    5 - Listar
                    6 - Sair
                    """;
            System.out.println(menu);
            var opcao = leitura.nextInt();
            leitura.nextLine();
            var selectedOption = MenuOption.values()[opcao - 1];

            switch (selectedOption) {
                case SAVE -> {
                    try {
                        var user = dao.save(requestToSave());
                        System.out.printf("Usuario cadastrado %s", user);
                    } catch (CustomException e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    } finally {
                        System.out.println("-------------------");
                    }

                }
                case UPDATE -> {
                    try {
                        var user = dao.update(requestToUpdate());
                        System.out.printf("Usuario alterado %s", user);
                    } catch (UserNotFoundExeption | EmptyStoregeException e) {
                        System.out.println(e.getMessage());
                    } catch (CustomException e){
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    } finally {
                        System.out.println("-------------------");
                    }
                }
                case DELETE -> {
                    try {
                        dao.delete(requestId());
                        System.out.println("Usuario excluído");
                    } catch (UserNotFoundExeption | EmptyStoregeException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println("-------------------");
                    }
                }
                case FIND_BY_ID -> {
                    try {
                        var id = requestId();
                        var user = dao.findById(id);
                        System.out.printf("usuario id: %s ", id);
                        System.out.println(user);
                    } catch (UserNotFoundExeption | EmptyStoregeException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case FIND_ALL -> {
                    var users = dao.findAll();
                    System.out.printf("Usuarios cadastrados");
                    users.forEach(System.out::println);
                }
                case EXIT -> System.exit(0);
            }
        }
    }

    private static long requestId() {
        System.out.println("Informe seu id de usuário");
        return leitura.nextLong();
    }

    private static UserModelDao requestToSave() {
        System.out.println("Informe seu nome de usuário");
        var name = leitura.next();
        System.out.println("Informe seu email");
        var email = leitura.next();
        System.out.println("Informe sua data de nascimento (dd/mm/yyyy)");
        var birthdayString = leitura.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);
        return validateInputs(0, name, email, birthday);
    }

    private static UserModelDao requestToUpdate() {
        var id = leitura.nextLong();
        System.out.println("Informe seu nome de usuário");
        var name = leitura.nextLine();
        System.out.println("Informe seu email");
        var email = leitura.nextLine();
        System.out.println("Informe sua data de nascimento (dd/mm/yyyy)");
        var birthdayString = leitura.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);
        return validateInputs(id, name, email, birthday);
    }

    private static UserModelDao validateInputs(final long id, final String name, final String email, final LocalDate birthday) {
        var user = new UserModelDao(0, name, email, birthday);
        try {
            VerifyModel(user);
            return user;
        } catch (ValidatorException e){
            throw new CustomException("O seu usuário cotem erros: " + e.getMessage(), e);
        }

    }
}