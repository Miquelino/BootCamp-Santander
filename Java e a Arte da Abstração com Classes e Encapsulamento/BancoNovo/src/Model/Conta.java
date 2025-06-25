package Model;

public class Conta extends Pessoa{

    private int conta;
    private int agencia;
    private double saldo;
    private double depositar;
    private double sacar;
    private double checkEspecial;


    public Conta(String name, int idade) {
        super(name, idade);
    }

    public Conta(String name, int idade, int conta, int agencia, double saldo) {
        super(name, idade);
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSacar() {
        return sacar;
    }

    public void setSacar(double sacar) {
        this.sacar = sacar;
    }

    public double getDepositar() {
        return depositar;
    }

    public void setDepositar(double depositar) {
        this.depositar = depositar;
    }

    public double getCheckEspecial() {
        return checkEspecial;
    }

    public void setCheckEspecial(double checkEspecial) {
        this.checkEspecial = checkEspecial;
    }

    public void validaChequeEspecial(){
        if (this.depositar <= 500){
            setCheckEspecial(50);
        } else if (this.)
    }
}
