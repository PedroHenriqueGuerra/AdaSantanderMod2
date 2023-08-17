package Aula4.exercicio.repository;

import Aula4.exercicio.entity.Cliente;
import Aula4.exercicio.entity.Pedido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PedidoRepositorio {

    private List<Pedido> pedidoList;

    public PedidoRepositorio(){
        this.pedidoList = new ArrayList<Pedido>();
    }

    public void adicionarPedido(Pedido pedido){
        this.pedidoList.add(pedido);
    }

    public void removerPedido(Pedido pedido){
        Iterator<Pedido> iterator = pedidoList.iterator();
        while (iterator.hasNext()){
            Pedido comparar = iterator.next();
            if(comparar.getNumeroPedido().equals(pedido.getNumeroPedido())){
                iterator.remove();
                break;
            }
        }
    }

    public List<Pedido> listarPedidos(){
        return new ArrayList<>(pedidoList);
    }

    public List<Pedido> buscarClientePedido(Cliente cliente){
        List<Pedido> pedidos = new ArrayList<>();
        for(Pedido pedido : pedidoList){
            if(pedido.getCliente().equals(cliente)){
                pedidos.add(pedido);
                return pedidos;
            }
        }
        return null;
    }

}
