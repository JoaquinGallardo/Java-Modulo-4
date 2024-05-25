package Banco;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner leer = new Scanner(System.in);

    static String bienvenida = """
                *********************************************
                **         Bienvenido a Alke Bank          **
                *********************************************
                **         ¿Desea entrar al menu?          **
                *********************************************
                **  1- Entrar                              **
                **  2- No entrar                           **
                *********************************************""";



    public static void introMenu() throws Exception {
        System.out.println(bienvenida);
        Scanner sc = new Scanner(System.in);


    byte opcionMenu = leer.nextByte();
        if(opcionMenu==1)
    {
printMenu(cuentas);
    }
        if(opcionMenu==2) {
        System.out.println("Saliendo la aplicación");
    }

}
    static String menu = """
                *********************************************
                **   1- Datos                              **
                **   2- Depostiar                          **
                **   3- Retirar                            **
                **   0- Salir                              **
                *********************************************""";

    public static void printMenu(List<Cuenta> cuentas) throws Exception {


        System.out.println(menu);
        execMenu(cuentas);
    }

    public static void execMenu(List<Cuenta> cuentas) throws Exception {

        Scanner sc = new Scanner(System.in);
        int comando = sc.nextInt();

        switch (comando) {

            case 1:
                Cliente cliente = new Cliente("Joaquín", "Gallardo", "12345678-9", "987654321");
//                Cuenta cuentaAhorro = new CuentaAhorro();
//                Cuenta cuentaCorriente = new CuentaCorriente();
//                Cuenta cuentaDolares = new CuentaDolares();
//                Cuenta cuentaEuro = new CuentaEuro();
//
//                cliente.addCuenta(cuentaAhorro);
//                cliente.addCuenta(cuentaCorriente);
//                cliente.addCuenta(cuentaDolares);
//                cliente.addCuenta(cuentaEuro);
//
//                cuentaAhorro.depositar(200000);
//                cuentaCorriente.depositar(69420);
//                cuentaDolares.depositar(2000);
//                cuentaEuro.depositar(3000);


                System.out.println("Cliente y cuentas creadas con éxito.\n" + cliente);

                execMenu(cuentas);
                System.out.println(cliente);
                Menu.printMenu(cliente.getCuentas());



                break;

//            case 2:
//                // Implement logic to handle deposit
//                System.out.println("Selecciona la cuenta donde deseas depositar (introduce el número):");
//                cuentaSeleccionada = sc.nextInt();
//                cuenta = findCuenta(cuentas, cuentaSeleccionada);
//                if (cuenta != null) {
//                    System.out.println("Ingrese monto a depositar:");
//                    double monto = sc.nextDouble();
//                    if (cuenta.depositar(monto)) {
//                        System.out.println("Depósito realizado con éxito.");
//                        System.out.println("Nuevo saldo: " + cuenta.getBalance());
//                    } else {
//                        System.out.println("Error al realizar el depósito.");
//                    }
//                } else {
//                    System.out.println("Cuenta no encontrada.");
//                }
//                break;
//            case 3:
//                // Implement logic to handle withdrawal
//                System.out.println("Selecciona la cuenta de la que deseas retirar (introduce el número):");
//                cuentaSeleccionada = sc.nextInt();
//                cuenta = findCuenta(cuentas, cuentaSeleccionada);
//                if (cuenta != null) {
//                    System.out.println("Ingrese monto a retirar:");
//                    double monto = sc.nextDouble();
//                    if (cuenta.retiro(monto)) {
//                        System.out.println("Retiro realizado con éxito.");
//                        System.out.println("Nuevo saldo: " + cuenta.getBalance());
//                    } else {
//                        System.out.println("Saldo insuficiente o error al realizar el retiro.");
//                    }
//                } else {
//                    System.out.println("Cuenta no encontrada.");
//                }
//                break;
            case 0:
                System.out.println("Saliendo del sistema...");
                introMenu();
                break;
            default:
                System.out.println("Opción no válida.");
//        }
//    }
//
//    // Helper method to find a cuenta by number in the list
//    private static Cuenta findCuenta(List<Cuenta> cuentas, int numeroCuenta) {
//        for (Cuenta cuenta : cuentas) {
//            if (cuenta.getNumero() == numeroCuenta) {
//                return cuenta;
//            }
//        }
//        return null;
        }
    }
}
