package Aula4.heranca;

public class Main {

    public static void main(String[] args) {
        Veiculo gol = new Carro("123", "azul", "gol", 2020, 4, "flex");

        imprimirDados(gol);
    }

    public static void imprimirDados(Veiculo veiculo){
        veiculo.exibirDados();
    }

}
