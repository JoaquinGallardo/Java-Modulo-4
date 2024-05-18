package Banco;

public class CuentaAhorro extends Cuenta{
    private int numRetiro;

    public CuentaAhorro() {
        super();
        this.numRetiro = 5;
    }

    @Override
    public boolean depositar(double deposito) {
        balance += deposito;
        return true;
    }

    @Override
    public boolean retiro(double retiro) {
        if(numRetiro > 0 && balance > retiro+300){
            numRetiro --;
            balance -= retiro+300;
            return true;

        }
        return false;
    }
}
