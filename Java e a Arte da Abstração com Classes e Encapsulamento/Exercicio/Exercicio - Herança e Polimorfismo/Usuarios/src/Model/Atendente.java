package Model;

public non-sealed class Atendente extends Usuario{

   private static double valorCaixa;

    public Atendente(String senha, String nome, String email, double valorCaixa) {
        super(senha, nome, email);
        Atendente.valorCaixa = valorCaixa;
    }


    public void closeCashRegister(){
        System.out.println("Fechando o caixa");
   }

    public static double getValorCaixa() {
        return valorCaixa;
    }

    public void setValorCaixa(double valorCaixa) {
        Atendente.valorCaixa = valorCaixa;
    }

    public void exibirMenuAtendente(){
        var menu = """
                1. Close Cash Register
                2. Make account changes
                3. Chance password
                4. Logoff
                """;

        System.out.println(menu);
        var opcao = leitura.nextInt();
        boolean continuar = true;
        while(continuar){
            switch (opcao){
                case 1 -> closeCashRegister();
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
