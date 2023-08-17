package Aula4.exercicio.service;

import Aula4.exercicio.entity.Cliente;
import Aula4.exercicio.entity.Pedido;
import Aula4.exercicio.entity.Prato;
import Aula4.exercicio.entity.Restaurante;
import Aula4.exercicio.repository.ClienteRepositorio;
import Aula4.exercicio.repository.PedidoRepositorio;
import Aula4.exercicio.repository.RestauranteRepositorio;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private ClienteRepositorio clienteRepositorio;
    private PedidoRepositorio pedidoRepositorio;
    private RestauranteRepositorio restauranteRepositorio;
    private RestauranteService restauranteService;
    private List<Cliente> clienteList;

    public ClienteService(ClienteRepositorio clienteRepositorio, PedidoRepositorio pedidoRepositorio,
                          RestauranteRepositorio restauranteRepositorio, RestauranteService restauranteService){
        this.clienteRepositorio = clienteRepositorio;
        this.pedidoRepositorio = pedidoRepositorio;
        this.restauranteRepositorio = restauranteRepositorio;
        this.restauranteService = restauranteService;
        this.clienteList = new ArrayList<>();
    }

    public void fazerPedido(int idCliente, String nomeCliente, int idRest, String nomeRest, List<Prato> pratos){
        Cliente cliente = clienteRepositorio.buscarPrato(idCliente, nomeCliente);
        Restaurante restaurante = restauranteRepositorio.buscarRestaurante(idRest, nomeRest);
        if(cliente != null && restaurante != null){
            Pedido pedido = new Pedido(cliente, restaurante);
            pedido.setPratos(pratos);
            pedidoRepositorio.adicionarPedido(pedido);
            restauranteService.adicionarPedido(pedido);
        }
    }

    public List<Pedido> pedidosCliente(int id, String nome){
        Cliente cliente = clienteRepositorio.buscarCliente(id, nome);
        if(cliente != null){
            List<Pedido> pedidosCliente = pedidoRepositorio.buscarClientePedido(cliente);
            return pedidosCliente;
        }
        return null;
    }


}
