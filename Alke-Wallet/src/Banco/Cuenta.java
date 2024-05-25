package Banco;

import java.util.Random;

public abstract class Cuenta {
    protected int numero;
    protected double balance;

    public Cuenta() {
        super();
        this.numero = new Random().nextInt(10000000) + 1000000;
        this.balance = 0;
    }

    public abstract boolean depositar(double deposito);
    public abstract boolean retiro(double retiro);

    @Override
    public String toString() {
        return "Cuenta{" +
                "balance=" + balance +
                '}';
    }
}
