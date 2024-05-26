package banco;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private String rut;
    private String password;
    List<Cuenta> cuentas;

    public Cliente(String nombre, String apellido, String rut, String password) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.password = password;
        cuentas = new LinkedList<>();

    }

    public void addCuenta(Cuenta c) {
        cuentas.add(c);
    }

    @Override
    public String toString() {
        String result = new String();
        for (int i = 0; i < cuentas.size(); i++) {
            result += cuentas.get(i);
        }

        return "*****************************************************\n"
                + String.format("**%15s%-10s%10s%-14s**\n", "Nombre:", nombre, "Apellido:", apellido)
                + String.format("**%15s%-10s%10s%-14s**\n", "Password:", password, "RUT:", rut)
                + "*****************************************************\n" + result
                + "*****************************************************";


    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }



    }

