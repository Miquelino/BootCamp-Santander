package Model;

public record Saude(double valor, double aliquota) implements Calcular{
    @Override
    public double tributo() {
        return valor * aliquota;
    }
}
