package BootCampo_Santander2025.ContaBanco.Entities;

public class Usuario {

    private String nome;
    private int idade;
    private String email;
    private String cidade;

    public Usuario(String nome, int idade, String email, String cidade) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

}
