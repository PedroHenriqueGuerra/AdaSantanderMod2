package Aula4.exercicio.repositorio;

import Aula4.exercicio.dominio.Prato;

import java.util.ArrayList;
import java.util.List;

public class PratoRepositorio {

    private List<Prato> lista;

    public PratoRepositorio(){
        lista = new ArrayList<>();
    }

    public void add(Prato prato){
        this.lista.add(prato);
    }

    public Prato get(String nome){
        for(Prato prato : lista){
            if(prato.getNome().equals(nome)){
                return prato;
            }
        }
        return null;
    }


}
