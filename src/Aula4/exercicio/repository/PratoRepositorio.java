package Aula4.exercicio.repository;

import Aula4.exercicio.entity.Prato;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PratoRepositorio {

    private List<Prato> pratoList;

    public PratoRepositorio(){
        pratoList = new ArrayList<>();
    }

    public void addPrato(Prato prato){
        this.pratoList.add(prato);
    }

    public Prato buscarPrato(int id, String nome){
        for(Prato prato : pratoList){
            if(prato.getNome().equals(nome) || prato.getIdentificador().equals(id)){
                return prato;
            }
        }
        return null;
    }

    public Prato removerPrato(Prato prato){
        Iterator<Prato> iterator = pratoList.iterator();
        while(iterator.hasNext()){
            Prato comparar = iterator.next();
            if(comparar.getIdentificador().equals(prato.getIdentificador()) && comparar.getNome().equals(prato.getNome())){
                return prato;
            }
        }
        return null;
    }

    public List<Prato> listarPratos(){
        return new ArrayList<>(pratoList);
    }


}
