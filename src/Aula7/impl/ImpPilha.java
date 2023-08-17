package Aula7.impl;

import Aula7.Pilha;

import java.util.EmptyStackException;

public class ImpPilha extends Pilha {


    @Override
    public void push(Object obj) {
        pilha.add(obj);
    }

    @Override
    public Object pop() {
        if(pilha.isEmpty()){
            throw new EmptyStackException();
        }
        Object obj = pilha.get(0);
        pilha.remove(0);
        return obj;
    }

    @Override
    public Object peek() {
        if(pilha.isEmpty()){
            throw new EmptyStackException();
        }
        return pilha.get(0);
    }

}
