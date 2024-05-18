package Banco;

public class CuentaCorriente extends Cuenta{
private int numCheque;

    public CuentaCorriente() {
        numCheque = 0;
    }

    @Override
    public boolean depositar(double deposito) {
        balance +=  deposito;
        return true;
    }

    @Override
    public boolean retiro(double retiro) {
        if(balance > retiro) {
            balance -= retiro;
        return true;
        }
        return false;
    }
}
