package Model;

public class Conta extends Pessoa{

    private int numeroConta;
    private int agencia;
    private double saldo;
    private double depositar;
    private double sacar;
    private double checkEspecial;

    private Conta conta;

    public Conta(String name, int idade) {
        super(name, idade);
    }

    public Conta(String name, int idade, int numeroConta, int agencia) {
        super(name, idade);
        this.numeroConta = numeroConta;
        this.agencia = agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
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
        this.saldo -= this.sacar = sacar;
    }

    public double getDepositar() {
        return depositar;
    }

    public void setDepositar(double depositar) {
        this.saldo += this.depositar = depositar;
    }

    public double getCheckEspecial() {
        return checkEspecial;
    }

    public void setCheckEspecial(double checkEspecial) {
        this.checkEspecial = checkEspecial;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double validaChequeEspecial(){
        if (this.depositar <= 500){
            setCheckEspecial(50);
        } else if (this.depositar > 500){
            setCheckEspecial((50/100) * 500);
        }
        return this.checkEspecial;
    }

    @Override
    public String toString() {
        return "NumeroConta: " + numeroConta +
                " Agencia: " + agencia +
                " Saldo: " + saldo;
    }
}
