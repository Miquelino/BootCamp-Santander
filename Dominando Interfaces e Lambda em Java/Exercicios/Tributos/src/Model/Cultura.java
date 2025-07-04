package Model;

public record Cultura(double valor, double aliquota) implements Calcular{
    @Override
    public double tributo() {
        return valor * aliquota;
    }
}
