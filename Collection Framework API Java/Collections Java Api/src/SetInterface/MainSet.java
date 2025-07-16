package SetInterface;

import SetInterface.OperacoesBasicas.ConjuntoConvidados;
import SetInterface.Ordenacao.CadastroProdutos;
import SetInterface.Pesquisa.AgendaContatos;

public class MainSet {
    public static void main(String[] args){

        CadastroProdutos cadastroProdutos = new CadastroProdutos();
        cadastroProdutos.adicionarProduto(1L, "Produto 5", 15d, 5);
        cadastroProdutos.adicionarProduto(2L, "Produto 0", 20d, 10);
        cadastroProdutos.adicionarProduto(1L, "Produto 3", 10d, 2);
        cadastroProdutos.adicionarProduto(9L, "Produto 9", 2d, 2);

        System.out.println(cadastroProdutos.exibirProdutoPorNome());
        System.out.println(cadastroProdutos.exibirPorPreco());

//        AgendaContatos agendaContatos = new AgendaContatos();
//
//        agendaContatos.adicionarContato("Camila", 123);
//        agendaContatos.adicionarContato("Camila", 0);
//        agendaContatos.adicionarContato("Camila C", 111);
//        agendaContatos.adicionarContato("Camila Dio", 456);
//        agendaContatos.adicionarContato("Maria Silva", 111);
//
//        agendaContatos.exibirContato();
//
//        System.out.println(agendaContatos.pesquisarPorNome("Camila"));
//        System.out.println("Contato atualizado: " + agendaContatos.atualizarNumeroContato("Maria Silva", 555));
//
//        agendaContatos.exibirContato();


//        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
//        conjuntoConvidados.adicionarConvidado("Convidado 1", 1);
//        conjuntoConvidados.adicionarConvidado("Convidado 2", 2);
//        conjuntoConvidados.adicionarConvidado("Convidado 3", 3);
//        conjuntoConvidados.adicionarConvidado("Convidado 4", 4);
//        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidados dentro do Set de convidados");
//        conjuntoConvidados.removerConvidadoPorCodigoConvite(1);
//        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidados dentro do Set de convidados");
    }
}
