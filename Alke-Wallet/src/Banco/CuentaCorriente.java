package Banco;

public class CuentaCorriente extends Cuenta{
private double maxDeposito;
private double depositoActual;

    public CuentaCorriente() {
        super(Moneda.CLP);
        this.maxDeposito = 5000000;
        this.depositoActual = 0;

    }

    @Override
    public boolean depositar(double deposito) {
        if(maxDeposito < (depositoActual+deposito)) {
            return false;
        }
        balance += deposito;
        depositoActual += deposito;
        return true;
    }

    @Override
    public boolean retiro(double retiro) {
        if(balance > retiro + 300) {
            return false;
        }
        balance -= retiro + 300;
        return true;
    }
}
