package Banco;

public class CuentaEuro extends Cuenta implements ConversorMoneda {
    private double maxDeposito;
    private double depositoActual;

    public CuentaEuro() {
        super(Moneda.EUR);
        this.maxDeposito = 50000;
        this.depositoActual = 0;
    }

    @Override
    public boolean depositar(double deposito) {
        if (maxDeposito < depositoActual + deposito) {
            return false;
        }
        else {
            balance += deposito;
            depositoActual += deposito;
            return true;
        }
    }

    @Override
    public boolean retiro(double retiro) {
        if (balance < retiro*1.02){
            return false;
        }
        else {
            balance -= retiro*1.02;
            return true;
        }
    }

    @Override
    public double convertir(double monto) {
        return monto*986;
    }
}