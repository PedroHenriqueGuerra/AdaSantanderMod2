package Aula2;

import java.util.Objects;

public class Conta {

    public Cliente cliente;
    private int numero;
    private double saldo;

    public Conta(Cliente cliente, int numeroConta, double saldo){
        this.cliente = cliente;
        this.numero = numeroConta;
        this.saldo = saldo;
    }


    public void depositar(double quantia) {
        this.saldo += quantia;
    }

    public boolean sacar(double quantia) {
        if (quantia > this.saldo) {
            return false;
        }
        this.saldo -= quantia;
        return true;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, numero, saldo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        return Objects.equals(cliente, other.cliente) && numero == other.numero
                && Double.doubleToLongBits(saldo) == Double.doubleToLongBits(other.saldo);
    }

    @Override
    public String toString() {
        return cliente + ", Conta numero=" + numero + ", saldo=" + saldo;
    }

}
