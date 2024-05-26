package banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = new Cliente("Joaquín", "Gallardo", "12345678-9", "987654321");


        Cuenta cuentaAhorro = new CuentaAhorro();
        Cuenta cuentaVista = new CuentaVista();
        Cuenta cuentaDolar = new CuentaDolar();
        Cuenta cuentaEuro = new CuentaEuro();


        cliente.addCuenta(cuentaAhorro);
        cliente.addCuenta(cuentaVista);
        cliente.addCuenta(cuentaDolar);
        cliente.addCuenta(cuentaEuro);

        cuentaAhorro.depositar(200000);
        cuentaVista.depositar(69420);
        cuentaDolar.depositar(10000);
        cuentaEuro.depositar(5000);

        System.out.println(cliente);
        Menu.printMenu(cliente.getCuentas());



    }



}
