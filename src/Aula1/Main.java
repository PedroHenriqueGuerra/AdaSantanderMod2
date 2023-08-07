package Aula1;

public class Main {

    public static void main(String[] args) {

        Contato contato1 = new Contato();
        contato1.nome = "pedro";
        contato1.numero = "999662233";

        Contato contato2 = new Contato();
        contato2.nome = "joao";
        contato2.numero = "999664455";

        Contato contatoADeletar = new Contato();
        contatoADeletar.nome = "joao";
        contatoADeletar.numero = "999664455";

        Contato contato3 = new Contato();
        contato3.nome = "jose";
        contato3.numero = "999667788";

        Contato[] lista = new Contato[] {contato1, contato2, contato3};

        Agenda agenda = new Agenda();
        agenda.contatos = lista;

        System.out.println("Imprimindo agenda");
        agenda.imprimirAgenda();

        System.out.println("Buscando pedro");
        Contato pedro = agenda.buscarPorNome("pedro");

        System.out.println("Detalhar");
        pedro.detalhar();

        System.out.println("ligar");
        pedro.ligar();

        System.out.println("Apagando contato: " + contatoADeletar);
        agenda.deletar(contatoADeletar);

        System.out.println("Contato Maria apagado");
        System.out.println();

        System.out.println("Imprimindo agenda");
        agenda.imprimirAgenda();
    }
}
