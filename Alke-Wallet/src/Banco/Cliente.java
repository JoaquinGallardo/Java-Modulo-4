package Banco;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private String rut;
    private String password;
    private List<Cuenta> cuentas;

    public Cliente(String nombre, String apellido, String rut, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.password = password;
        cuentas = new LinkedList<Cuenta>(){
            @Override
            public String toString() {
                String result = new String();
                for(int i = 0; i< cuentas.size(); i++) {
                    result += cuentas.get(i);

                }
                return result;
            }

        };
    }

    public void addCuenta(Cuenta c){
        cuentas.add(c);

    }

    @Override
    public String toString() {
        return String.format("**%10s%-12s%s%-10s**\n", "Nombre:", nombre, "Apellido:", apellido)+
                String.format("**%7s%-15s%s%-10s**\n", "Rut:", rut, "Password:", password)+
                "*********************************************\n"+
                cuentas +
                "*********************************************\n";

//        return "Cliente{" +
//                "nombre='" + nombre + '\'' +
//                ", apellido='" + apellido + '\'' +
//                ", rut='" + rut + '\'' +
//                ", password='" + password + '\'' +
//                ", cuentas=" + cuentas +
//                '}';
    }
}
