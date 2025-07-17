package Listas.CarrinhoCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList = new ArrayList<>();


    public void adicionarItem(String nome, double preco, int quantidade){
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> removeItem = new ArrayList<>();
        for (Item i : itemList){
            if (i.getNome().equalsIgnoreCase(nome)){
                removeItem.add(i);
            }
        }
        itemList.removeAll(removeItem);
    }

    public double calcularValorTotal(){
        double valorTotal = 0d;
        if (!itemList.isEmpty()){
            for (Item item : itemList){
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal *= valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public void exibirItem(){
        System.out.println(itemList);
    }


}
