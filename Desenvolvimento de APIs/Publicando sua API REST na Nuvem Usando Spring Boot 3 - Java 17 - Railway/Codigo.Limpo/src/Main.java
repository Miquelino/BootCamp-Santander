//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Correto
        String username = "Rey222"; // ligado a linha 16
        String productName = "mouse"; // ligado a linha 16

        double sendingTax = 0.5; // ligado a linha 17
        double sendingTaxBase = 0.5; // ligado a linha 17
        double sendingTaxMaximun = 0.5; // ligado a linha 17
        double userPersonaSedingTax = 3.0; // ligado a linha 18
        double rangeOfDaysToSedingProdutct = 1; // ligado a linha 21 e 22


        // Subjetivo e errado
        String name = "Reynaldo";
        double tax = 0.1;
        double myST = 3.0;
        double range = 1;
        double rng = 1;

        // Número mágico é um número jogado sem sentido ou aleatoriamente
        if (tax < 2.0) {
        } // ligado a linha 23 ao 25

        // Dando sentido ao número
        double taxLimitByCountry = 2.0;
        if (sendingTax < taxLimitByCountry) {
        }


    }

    // Colher os dados do usuario em um sistema de envio, salvar isso em um banco de dados de histórico
    // depois gerar um pedido com código de rastreio

    /**
     * Problemas do código abaixo
     * Nomes subjetivos
     * Excesso de parametros
     * Nome da função está subetiva
     * Função faz tudo
     */

    public void seding(String name, String zip, String data, String coutry) {
        // pegar dados usuário
        var user = name;
        var zipcode = zip;

        // comunicar com banco de dados
        var datax = data;
        var country = coutry;
    }

    /**
     * Função da maneira certa abaixo.
     * Colher dos usuarios em um sistema de envio,
     * salvar isso em um banco de dados de histórico,
     * depois gerar um pedido com código de rastreio
     */

    /**
     * prefixos
     * get
     * load
     * do / make
     * delete
     * save
     */

    public void makeProductOrder(){
        getDataFromUserToSending();
        saveToDatabaseHistorico();
        createTicketToOrder();
    }

    // Colher dos usuarios em um sistema de envio
    public String getDataFromUserToSending() {

        return null;
    }

    // salvar isso em um banco de dados de histórico
    public void saveToDatabaseHistorico(){

    }

    // depois gerar um pedido com código de rastreio
    public String createTicketToOrder(){
        return null;
    }
}