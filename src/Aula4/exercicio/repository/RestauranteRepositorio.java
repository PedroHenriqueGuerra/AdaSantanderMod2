package Aula4.exercicio.repository;

import Aula4.exercicio.entity.Prato;
import Aula4.exercicio.entity.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class RestauranteRepositorio {

    private List<Restaurante> restauranteList;

    public RestauranteRepositorio(){
        restauranteList = new ArrayList<>();
    }
    public void add(Restaurante restaurante) {
        this.restauranteList.add(restaurante);
    }

    public Restaurante buscarRestaurante(int id, String nome){
        for(Restaurante restaurante : restauranteList){
            if(restaurante.getNome().equals(nome) || restaurante.getIdentificador().equals(id)){
                return restaurante;
            }
        }
        return null;
    }

    public List<Restaurante> listarRestaurantes(){
        return new ArrayList<>(restauranteList);
    }

    public List<Prato> listarPratos(int id, String nome){
        Restaurante restaurante = buscarRestaurante(id, nome);
        if(restaurante != null){
            return restaurante.getPratosDisponiveis();
        }
        return null;
    }
}
