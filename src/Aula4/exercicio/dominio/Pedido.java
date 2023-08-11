package Aula4.exercicio.dominio;

public class Pedido {

    private Prato prato;
    private String endereco;

    public Pedido(Prato prato, String endereco){
        this.prato = prato;
        this.endereco = endereco;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
