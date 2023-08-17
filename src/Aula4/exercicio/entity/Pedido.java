package Aula4.exercicio.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {

    private static Integer ultimoNumeroPedido = 0;
    private Integer numeroPedido;
    private List<Prato> pratos;
    private Cliente cliente;
    private Restaurante restaurante;

    public Pedido(Cliente cliente, Restaurante restaurante){
        this.numeroPedido = ultimoNumeroPedido++;
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.pratos = new ArrayList<>();
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, numeroPedido, restaurante);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        return Objects.equals(cliente, other.cliente) && Objects.equals(numeroPedido, other.numeroPedido)
                && Objects.equals(restaurante, other.restaurante);
    }

    @Override
    public String toString() {
        return "Pedido: numeroPedido: " + numeroPedido + ", cliente: " + cliente + ", restaurante: " + restaurante
                + ", pratos: " + pratos + ".";
    }
}
