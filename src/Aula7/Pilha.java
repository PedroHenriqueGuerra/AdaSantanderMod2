package Aula7;

import java.util.ArrayList;

public abstract class  Pilha {


    protected ArrayList<Object> pilha;
    public abstract void push(Object obj);
    public abstract Object pop();
    public abstract Object peek();


}
