package Model;

public record Alimentacao(double valor, double aliquota) implements Calcular{
    @Override
    public double tributo() {
        return valor * aliquota;
    }
}
