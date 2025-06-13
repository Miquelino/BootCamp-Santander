package BootCampo_Santander2025.ContaBanco.Entities;

public class Conta {

    private int numero;
    private String agencia;
    private Usuario titular;
    private Banco banco;
    private double saldo;

    public Conta(int numero, String agencia) {
        this.numero = numero;
        this.agencia = agencia;
    }

    public Usuario getTitular() {
        return titular;
    }

    public void setTitular(Usuario titular) {
        this.titular = titular;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public boolean sacar(double valor){
        if (valor <= saldo){
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente!");
            return false;
        }
    }

    public void exibirInformacoes() {
        System.out.println("Conta: " + numero + " | Agência: " + agencia);
        System.out.println("Titular: " + titular.getNome());
        System.out.println("Banco: " + banco.getNome());
    }
}
