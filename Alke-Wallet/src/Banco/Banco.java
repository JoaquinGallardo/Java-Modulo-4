package Banco;

public class Banco {
    public static void main(String[] args) {
        var cliente1 = new Cliente("Joaquín", "Gallardo", "12345678-9", "123456789");
    var cuentaAhorro = new CuentaAhorro();
    var cuentaCorriente = new CuentaCorriente();
        cliente1.addCuenta(cuentaAhorro);
        cliente1.addCuenta(cuentaCorriente);
        cuentaAhorro.depositar(100000);
        cuentaCorriente.depositar(69420);


        String bienvenida = """
                *********************************************
                **         Bienvenido a Alke Bank          **
                *********************************************""";
        String menu = """
                *********************************************
                **   1- Ingresar                           **
                **   2- Depostiar                          **
                **   3- Retirar                            **
                **   0- Salir                              **
                *********************************************""";
        System.out.println(bienvenida);
        System.out.println(menu);
        System.out.println(cliente1);
    }
}
