package Model;

public record Insta(String mensagem) implements Mensagem{
    @Override
    public String mensagem() {
        return mensagem;
    }
}
