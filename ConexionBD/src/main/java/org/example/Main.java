package org.example;

import org.example.modelo.Empleado;
import org.example.repositorio.EmpleadoRepositorio;
import org.example.repositorio.Repositorio;
import org.example.vista.SwingApp;

import java.sql.SQLException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        Repositorio<Empleado> repositorio = new EmpleadoRepositorio();

       repositorio.encontrarTodo().forEach(System.out::println);
       //repositorio.eliminar(5);
        SwingApp swingApp = new SwingApp();
        swingApp.setVisible(true);
    }
}