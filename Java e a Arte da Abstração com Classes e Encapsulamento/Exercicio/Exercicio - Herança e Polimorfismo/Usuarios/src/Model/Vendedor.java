package Model;

public non-sealed class Vendedor extends Usuario{

    private static int qtdVenda;

    public Vendedor(String senha, String nome, String email, int qtdVenda) {
        super(senha, nome, email);
        Vendedor.qtdVenda = qtdVenda;
    }

    public void qtdVenda(){
        System.out.println("Sales Quantity: " + getQtdVenda());
    }

    public static int getQtdVenda() {
        return qtdVenda;
    }

    public void setQtdVenda(int qtdVenda) {
        Vendedor.qtdVenda = qtdVenda;
    }

    public void exibirMenuVendedor(){
        var menu = """
                1. Make Sale
                2. Make account changes
                3. Chance password
                4. Sales Quantity
                5. Logoff
                """;

        System.out.println(menu);
        var opcao = leitura.nextInt();
        boolean continuar = true;
        while(continuar){
            switch (opcao){
                case 1 -> qtdVenda();
                case 2 -> update();
                case 3 -> updatePassword();
                case 4 -> logoff(continuar);
                default -> throw new IllegalStateException("Unexpected value: " + opcao);
            }
        }
    }

    @Override
    Usuario convert(Usuario usuario) {
        return null;
    }


}
