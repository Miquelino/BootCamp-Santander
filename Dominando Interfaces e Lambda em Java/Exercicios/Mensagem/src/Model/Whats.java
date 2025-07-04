package Model;

public record Whats(String mensagem) implements Mensagem{
    @Override
    public String mensagem() {
        return mensagem;
    }
}
