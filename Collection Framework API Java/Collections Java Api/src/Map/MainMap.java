package Map;

import Map.OperacoesBasicas.AgendaContatos;
import Map.Ordenacao.AgendaEventos;
import Map.Pesquisa.EstoqueProdutos;

import java.time.LocalDate;
import java.time.Month;

public class MainMap {
    public static void main(String[] args){


        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Evento 1", "Atracao 1");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Evento 2", "Atracao 2");
        agendaEventos.adicionarEvento(LocalDate.of(2000, Month.JANUARY, 10), "Evento 3", "Atracao 3");
        agendaEventos.adicionarEvento(LocalDate.of(2025, Month.OCTOBER, 12), "Evento 4", "Atracao 4");

        agendaEventos.exibirAgenda();
        agendaEventos.obterProximoEvento();
//        EstoqueProdutos estoque = new EstoqueProdutos();
//        estoque.adicionarProduto(1L, "Produto A", 10, 5.0);
//        estoque.adicionarProduto(2L, "Produto B", 5, 10.0);
//        estoque.adicionarProduto(3L, "Produto C", 2, 15.0);
//
//        estoque.exibirProduto();
//
//        System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());
//        System.out.println("Produto mais caro: " + estoque.obterProdutoMaisCaro());

//        AgendaContatos agendaContatos = new AgendaContatos();
//
//        agendaContatos.adicionarContato("Camila", 123);
//        agendaContatos.adicionarContato("Camila", 0);
//        agendaContatos.adicionarContato("Camila C", 111);
//        agendaContatos.adicionarContato("Camila Dio", 456);
//        agendaContatos.adicionarContato("Maria Silva", 111);
//
//        agendaContatos.exibirContatos();
//
//        agendaContatos.removerContato("Maria Silva");
//        agendaContatos.exibirContatos();
//
//        //System.out.println(agendaContatos.pesquisarPorNome("Camila"));
//        System.out.println("O numero é: " + agendaContatos.pesquisarPorNome("Camila Dio"));

    }
}
