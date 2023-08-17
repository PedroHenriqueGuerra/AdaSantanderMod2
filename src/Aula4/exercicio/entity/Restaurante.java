package Aula4.exercicio.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Restaurante {

    private static Integer ultimoIdentificador = 0;
    private Integer identificador = 0;
    private String nome;
    private String endereco;
    private List<Prato> pratosDisponiveis;


    public Restaurante(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
        this.pratosDisponiveis = new ArrayList<>();
        this.identificador = ultimoIdentificador++;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public List<Prato> getPratosDisponiveis() {
        return pratosDisponiveis;
    }

    public void setPratosDisponiveis(List<Prato> pratosDisponiveis) {
        this.pratosDisponiveis = pratosDisponiveis;
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
    @Override
    public int hashCode() {
        return Objects.hash(endereco, identificador, nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Restaurante other = (Restaurante) obj;
        return Objects.equals(endereco, other.endereco) && Objects.equals(identificador, other.identificador)
                && Objects.equals(nome, other.nome);
    }

    @Override
    public String toString() {
        return "Restaurante: identificador=" + identificador + ", nome=" + nome + ", endereco=" + endereco + ", pratos="
                + pratosDisponiveis + ".";
    }


}
