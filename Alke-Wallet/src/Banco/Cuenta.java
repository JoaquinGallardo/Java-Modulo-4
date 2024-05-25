package Banco;

import java.util.Random;

public abstract class Cuenta {
    protected int numero;
    protected double balance;
    protected Moneda moneda;

    public Cuenta(Moneda moneda) {
        super();
        this.numero = new Random().nextInt(10000000) + 1000000;
        this.balance = 0;
        this.moneda = moneda;

    }



    public abstract boolean depositar(double deposito);
    public abstract boolean retiro(double retiro);

    @Override
    public String toString() {
        //*****************************************************
        return String.format("**%15s%-5s%8s%.2f  **\n", "Numero Cta:",
                Integer.toString(numero), "Saldo:", balance)+
                String.format("**%15s%-10s%10s%4s  **\n", "Moneda:",
                        moneda, "", "");
        //return "Cuenta [numero=" + numero + ", saldo=" + saldo + "]";
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;

    }

    public Moneda getMoneda() {
        return moneda;
    }
}
