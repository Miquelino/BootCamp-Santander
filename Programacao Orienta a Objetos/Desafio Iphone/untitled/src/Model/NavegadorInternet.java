package Model;

public class NavegadorInternet {

    private int qtdAba = 0;

    public void exibirPagina(String url){
        System.out.println("Exibindo a página WEB");
        qtdAba++;
    }

    public void adicionarNovaAba(){
        System.out.println("Abrindo nova aba WEB");
        qtdAba++;
    }

    public void atualizarPagina(){
        System.out.println("Atualizando página WEB");
    }

    public void fecharPagina(){
        if (qtdAba < 0){
            System.out.println("Não existe página WEB aberta.");
        } else {
            System.out.println("Fechando página WEB");
            qtdAba--;
        }
    }

}
