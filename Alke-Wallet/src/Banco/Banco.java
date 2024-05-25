package Banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    public static void main(String[] args) throws Exception {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = new Cliente("Joaquín", "Gallardo", "12345678-9", "123456789");
        Cuenta cuentaAhorro = new CuentaAhorro();
        Cuenta cuentaCorriente = new CuentaCorriente();
        Cuenta cuentaDolares = new CuentaDolares();
        CuentaEuro cuentaEuro = new CuentaEuro();

        cliente.addCuenta(cuentaCorriente);
        cliente.addCuenta(cuentaAhorro);
        cliente.addCuenta(cuentaDolares);
        cliente.addCuenta(cuentaEuro);


        cuentaAhorro.depositar(100000);
        cuentaCorriente.depositar(69420);
        cuentaDolares.depositar(2000);
        cuentaEuro.depositar(3000);



        Menu.introMenu();


//
//    System.out.printf("Tengo $%.2f dolares, lo que equivale a $%.2f pesos.\n", cuenta.getBalance(), ((ConversorMoneda) cuenta).convertir(cuentaDolares.getBalance()));
//
//            }
//        }
    }

    public static void main() {
    }
}
