package Aula4.exercicio.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurante {


    private String nome;
    private String endereco;
    private ArrayList<Prato> pratosDisponiveis;


    public Restaurante(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
        this.pratosDisponiveis = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public List<Prato> findAll() {
        return Collections.unmodifiableList(pratosDisponiveis);
    }


}
