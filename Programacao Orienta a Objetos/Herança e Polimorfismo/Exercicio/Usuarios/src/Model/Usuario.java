package Model;

import java.util.Scanner;

public sealed abstract class Usuario permits Gerente, Vendedor, Atendente{

    Scanner leitura = new Scanner(System.in);

    private String nome;
    private String email;
    private String senha;
    private boolean admistrador;

    public Usuario(String senha, String nome, String email) {
        this.senha = senha;
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmistrador() {
        return admistrador;
    }

    public void setAdmistrador(boolean admistrador) {
        this.admistrador = true;
    }

    public void login(){
        System.out.println("Digite o seu login");
        var login = leitura.next();
        System.out.println("Digite sua senha");
        var password = leitura.next();
        if ((login == this.nome) && (password == this.senha)){
            System.out.println("Seja bem vindo ao sistema");
            System.out.println("----------------------------------");
        } else {
            System.out.println("Usuário ou senha inválida!");
        }
    }

    public boolean logoff(boolean sair){
        System.out.println("Saindo do programa...");
        sair = false;
        return sair;
    }

    public void update(){
        var menuUpdate = """
                1. Update name
                2. Update email
                3. Update password
                3. Return to previous menu
                """;

        System.out.println(menuUpdate);
        var opcao = leitura.nextInt();

        boolean continuar = true;
        while(continuar){
            switch (opcao){
                case 1 -> updateName();
                case 2 -> updateEmail();
                case 3 -> updatePassword();
                case 4 -> continuar = false;
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    public void updatePassword(){
        System.out.println("New Password: ");
        this.senha = leitura.next();
    }

    public void updateName(){
        System.out.println("New Name: ");
        this.nome = leitura.next();
    }

    public void updateEmail(){
        System.out.println("New Email: ");
        this.email = leitura.next();
    }

    abstract Usuario convert(Usuario usuario);

}
