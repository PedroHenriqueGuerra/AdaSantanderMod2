package Aula1;

public class Contato {
    String nome;
    String numero;


    public void ligar() {
        System.out.println("ligando para: " + nome);
    }

    public void detalhar() {
        System.out.println("Nome: " + nome);
        System.out.println("Numero: " + numero);
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object c) {
        if (c instanceof Contato contatoAComparar) {
            if (contatoAComparar.nome.equals(nome)
                    && contatoAComparar.numero.equals(numero)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}