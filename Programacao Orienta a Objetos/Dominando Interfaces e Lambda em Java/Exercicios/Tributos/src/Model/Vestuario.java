package Model;

public record Vestuario(double valor, double aliquota) implements Calcular{
    @Override
    public double tributo() {
        return valor * aliquota;
    }
}
