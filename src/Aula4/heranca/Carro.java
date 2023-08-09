package Aula4.heranca;

public class Carro extends Veiculo{

    private int qtdPortas;
    private String tipoCombustivel;

    public Carro(String placa, String cor, String modelo, int ano, int qtdPortas, String tipoCombustivel){
        super(placa, cor, modelo, ano);
        this.qtdPortas = qtdPortas;
        this.tipoCombustivel = tipoCombustivel;
    }


    public void exibirDados(){
        super.exibirDados();
        System.out.println("Quantidade de portas: " + qtdPortas);
        System.out.println("Tipo combustivel: " + tipoCombustivel);
    }
}
