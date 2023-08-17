package Aula4.exercicio.service;

import Aula4.exercicio.entity.Pedido;
import Aula4.exercicio.entity.Prato;
import Aula4.exercicio.entity.Restaurante;
import Aula4.exercicio.repository.RestauranteRepositorio;

import java.util.List;
import java.util.stream.Collectors;

public class RestauranteService {

    private RestauranteRepositorio restauranteRepositorio;
    private List<Pedido> pedidoList;

    public RestauranteService(RestauranteRepositorio restauranteRepositorio){
        this.restauranteRepositorio = restauranteRepositorio;
    }
    public void cadastrarRestaurante(Restaurante restaurante){
        restauranteRepositorio.add(restaurante);
    }

    public List<Restaurante> listarRestaurante(){
        return restauranteRepositorio.listarRestaurantes();
    }

    public void adicionarPrato(int id, String nome, Prato prato){
        Restaurante restaurante = restauranteRepositorio.buscarRestaurante(id, nome);
        if(restaurante != null){
            restaurante.getPratosDisponiveis().add(prato);
        }
    }

    public List<Prato> listarPratos(int id, String nome){
        return restauranteRepositorio.listarPratos(id, nome);
    }

    public List<Pedido> listarPedidosRest(int id, String nome){
        Restaurante restaurante = restauranteRepositorio.buscarRestaurante(id, nome);
            if(restaurante != null){
                return pedidoList.stream().filter(pedido -> pedido.getRestaurante().equals(restaurante)).collect(Collectors.toList());
            }
        return null;
    }


    public void adicionarPedido(Pedido pedido){
        pedidoList.add(pedido);
    }

}
