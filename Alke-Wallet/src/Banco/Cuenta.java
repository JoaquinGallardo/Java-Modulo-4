package Banco;

public abstract class Cuenta {
    protected double balance;

    public Cuenta() {
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
