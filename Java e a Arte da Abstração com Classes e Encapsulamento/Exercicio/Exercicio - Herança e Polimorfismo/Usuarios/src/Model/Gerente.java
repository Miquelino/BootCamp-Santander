package Model;

public non-sealed class Gerente extends Usuario{


    public Gerente(String senha, String nome, String email) {
        super(senha, nome, email);
    }

    public void generateFinancialReport(){
        System.out.println("Financial Report");
        System.out.println("Sales quantity" + Vendedor.getQtdVenda());
        System.out.println("Cash Value" + Atendente.getValorCaixa());
    }

    @Override
    Usuario convert(Usuario usuario) {
        return null;
    }

    public void exibirMenuGerente(){
        var menu = """
                1. Generate Financial Report
                2. Make account changes
                3. Chance password
                4. Logoff
                """;

        System.out.println(menu);
        var opcao = leitura.nextInt();
        boolean continuar = true;
        while(continuar){
            switch (opcao){
                case 1 -> generateFinancialReport();
                case 2 -> update();
                case 3 -> updatePassword();
                case 4 ->  logoff(continuar);
                default -> throw new IllegalStateException("Unexpected value: " + opcao);
            }
        }
    }
}

