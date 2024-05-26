package banco;

import java.util.List;
import java.util.Scanner;

public class Menu {
    static String bienvenida = """
			*****************************************************
			**          Bienvenido al Alke Banco               **
			
			**          Por favor ingrese una opción.          **
			
			*****************************************************""";

    static String menu = """
		
			
			** 1- Cuentas                                      **
			** 2- Depositar                                    **
			** 3- Retirar                                      **
			** 0- Salir                                        **
			*****************************************************""";

    public static void printMenu(List<Cuenta> cuentas) {
        System.out.println(bienvenida);
        System.out.println(menu);
        execMenu(cuentas);
    }

    public static void execMenu(List<Cuenta> cuentas) {

        Scanner sc = new Scanner(System.in);
        int comando = sc.nextInt();

        switch(comando) {
            case 1:
                System.out.println();
                System.out.println(cuentas);
                printMenu(cuentas);
                break;

            case 2:
                System.out.println("Ingrese cuenta para depositar");
                int origen = sc.nextInt();
                System.out.println("Ingrese el monto");
                double monto = sc.nextDouble();
                cuentas.get(origen).depositar(monto);
                printMenu(cuentas);
                break;
            case 3:
                System.out.println("Ingrese cuenta para retirar");
                 sc.nextInt();
                System.out.println("Ingrese el monto");
                  sc.nextDouble();
                printMenu(cuentas);
                break;
            case 0:
                System.out.println("Adiós");
        }

    }
}