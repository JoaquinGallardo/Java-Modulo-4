package org.example.vista;

import org.example.modelo.Empleado;
import org.example.repositorio.EmpleadoRepositorio;
import org.example.repositorio.Repositorio;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class SwingApp extends JFrame {

    private final Repositorio<Empleado> empleadoRepositorio;

    private final JTable tablaEmpleado;

    public SwingApp() {

        setTitle("Administrador de empleados");
        setSize(600, 230);
        //crear una tabla para empleados
        tablaEmpleado = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaEmpleado);
        add(scrollPane, BorderLayout.CENTER);
        // crear botones de la aplicación
        JButton agregarButton = new JButton("Agregar");
        JButton actualizarButton = new JButton("Actualizar");
        JButton eliminarButton = new JButton("Eliminar");
        //Configurar el panel con los botones
        JPanel panelButton = new JPanel();
        panelButton.add(agregarButton);
        panelButton.add(actualizarButton);
        panelButton.add(eliminarButton);
        add(panelButton, BorderLayout.SOUTH);
        //estilos
        //agregarButton.setBackground(new Color(164, 243, 160));
        agregarButton.setBackground(new Color(45, 228, 213));
        agregarButton.setForeground(Color.MAGENTA);
        actualizarButton.setBackground(new Color(174, 204, 68));
        actualizarButton.setForeground(new Color(7, 34, 165));
        eliminarButton.setBackground(Color.red);
        eliminarButton.setForeground(Color.white);
        empleadoRepositorio = new EmpleadoRepositorio(); //objeto creado para acceder a la base de datos.
        // agregar la acción de escuchar a los botones
        agregarButton.addActionListener(e -> {
            try {
                agregarEmpleado();
            } catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        });

    }

    private void agregarEmpleado() throws SQLException {

        JTextField nombre = new JTextField();
        JTextField primerApellido = new JTextField();
        JTextField segundoApellido = new JTextField();
        JTextField email = new JTextField();
        JTextField salario = new JTextField();
        Object[] campos = {
            "Nombre: ", nombre,
            "Primer Apellido: ", primerApellido,
            "Segundo Apellido: ", segundoApellido,
            "Email: ", email,
            "Salario: ", salario
        };
        int resultado = JOptionPane.showConfirmDialog(this, campos, "Agregar empleado", JOptionPane.OK_CANCEL_OPTION);

        if(resultado == JOptionPane.OK_OPTION){

            Empleado empleado = new Empleado();

            empleado.setNombre(nombre.getText());
            empleado.setPrimerApellido(primerApellido.getText());
            empleado.setSegundoApellido(segundoApellido.getText());
            empleado.setEmail(email.getText());
            empleado.setSalario(Float.parseFloat(salario.getText()));

            empleadoRepositorio.guardar(empleado);
            // Crear método refrescar/actualizar tablas
            JOptionPane.showMessageDialog(this, "Empleado agregado exitosamente.", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }


}
