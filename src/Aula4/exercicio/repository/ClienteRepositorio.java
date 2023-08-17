package Aula4.exercicio.repository;

import Aula4.exercicio.entity.Cliente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClienteRepositorio {

    private List<Cliente> clienteList;

    public ClienteRepositorio(){
        this.clienteList = new ArrayList<Cliente>();
    }

    public void addCliente(Cliente cliente){
        this.clienteList.add(cliente);
    }

    public void removerCliente(Cliente cliente){
        Iterator<Cliente> iterator = clienteList.iterator();
        while(iterator.hasNext()){
            Cliente comparar = iterator.next();
            if(comparar.getIdentificador().equals(cliente.getIdentificador()) && comparar.getNome().equals(cliente.getNome())){
                iterator.remove();
                break;
            }
        }
    }

    public Cliente buscarCliente(int id, String nome){
        for(Cliente cliente : clienteList){
            if(cliente.getIdentificador().equals(id) || cliente.getNome().equals(nome)){
                return cliente;
            }
        }
        return null;
    }

    public Cliente buscarPrato(int id, String nome){
        for (Cliente cliente : clienteList) {
            if (cliente.getIdentificador().equals(id) || cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> listarPratos() {
        return new ArrayList<>(clienteList);
    }

}
