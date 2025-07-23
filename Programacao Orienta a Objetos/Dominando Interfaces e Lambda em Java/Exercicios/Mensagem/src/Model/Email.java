package Model;

public record Email(String mensagem) implements Mensagem{
    @Override
    public String mensagem() {
        return mensagem;
    }
}
