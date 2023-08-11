package Aula4.exercicio.repositorio;

import Aula4.exercicio.dominio.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class RestauranteRepositorio {

    private List<Restaurante> lista;

    public RestauranteRepositorio(){
        lista = new ArrayList<>();
    }
    public void add(Restaurante restaurante) {
        this.lista.add(restaurante);
    }

    public Restaurante get(String nome){
        for(Restaurante restaurante : lista){
            if(restaurante.getNome().equals(nome)){
                return restaurante;
            }
        }
        return null;
    }
}
