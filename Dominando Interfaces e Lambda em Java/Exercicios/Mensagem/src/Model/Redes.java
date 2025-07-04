package Model;

public record Redes() implements Mensagem{

    @Override
    public String mensagem() {
        return "Compre na promoção";
    }

    public String SMS(){
        return mensagem();
    }

    public String Email(){
        return mensagem();
    }
    public String Insta(){
        return mensagem();
    }
    public String Whats(){
        return mensagem();
    }
}
