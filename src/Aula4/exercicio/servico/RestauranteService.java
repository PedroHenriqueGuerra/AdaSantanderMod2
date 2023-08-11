package Aula4.exercicio.servico;

import Aula4.exercicio.dominio.Restaurante;
import Aula4.exercicio.repositorio.RestauranteRepositorio;

public class RestauranteService {

    private RestauranteRepositorio restauranteRepositorio;

    public RestauranteService(RestauranteRepositorio restauranteRepositorio){
        this.restauranteRepositorio = restauranteRepositorio;
    }
    public void criarRestaurante(String nome, String endereco){

        var novoRestaurante = new Restaurante(nome, endereco);

        this.restauranteRepositorio.add(novoRestaurante);
    }

}
