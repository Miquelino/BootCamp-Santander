package Model;

public record SMS(String mensagem) implements Mensagem {

    @Override
    public String mensagem() {
        return mensagem;
    }
}
