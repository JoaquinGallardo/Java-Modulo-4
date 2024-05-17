package org.example.vista;

import org.example.modelo.Empleado;
import org.example.repositorio.EmpleadoRepositorio;
import org.example.repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class SwingApp extends JFrame {

    private final Repositorio<Empleado> empleadoRepositorio;

    private final JTable tablaEmpleado;

    public SwingApp() {

        setTitle("Administrador de empleados");
        setSize(1200, 460);
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
        refrescarTablaEmpleado();
        agregarButton.addActionListener(e -> {
            try {
                agregarEmpleado();
            } catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        });
actualizarButton.addActionListener(e -> actualizarEmpleado());
eliminarButton.addActionListener(e -> eliminarEmpleado());
    }

    private void actualizarEmpleado() {

        String empleadoIdStr = JOptionPane.showInputDialog(this, "Ingrese ID del empleado a actualizar por favor", "Actualiza empleado", JOptionPane.QUESTION_MESSAGE);
        if(empleadoIdStr != null){

            try{
                int empleadoId = Integer.parseInt(empleadoIdStr);
                Empleado empleado = empleadoRepositorio.obtenerPorId(empleadoId);
                if(empleado != null){
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
                    int confirmarResultado = JOptionPane.showConfirmDialog(this, campos, "Actualizar empleado", JOptionPane.OK_CANCEL_OPTION);
                    if(confirmarResultado==JOptionPane.OK_OPTION){
                        empleado.setNombre(nombre.getText());
                        empleado.setPrimerApellido(primerApellido.getText());
                        empleado.setSegundoApellido(segundoApellido.getText());
                        empleado.setEmail(email.getText());
                        empleado.setSalario(Float.parseFloat(salario.getText()));
                        empleadoRepositorio.guardar(empleado);
                        refrescarTablaEmpleado();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(this, "ID no válido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido para el ID por favor", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al obtener los datos", "Error al cargar datos", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private void eliminarEmpleado() {
        String empleadoIdStr = JOptionPane.showInputDialog(this, "Ingrese ID del empleado a actualizar por favor", "Actualiza empleado", JOptionPane.QUESTION_MESSAGE);
        if(empleadoIdStr != null){
            try{
                int empleadoId = Integer.parseInt(empleadoIdStr);
                int confirmarEliminacion = JOptionPane.showConfirmDialog(this, "Seguro desea eliminar empleado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if(confirmarEliminacion == JOptionPane.YES_OPTION){
                empleadoRepositorio.eliminar(empleadoId);
                refrescarTablaEmpleado();
            }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido para el ID por favor", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e){
                throw new RuntimeException();
            }
        }
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
            refrescarTablaEmpleado();
            JOptionPane.showMessageDialog(this, "Empleado agregado exitosamente.", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void refrescarTablaEmpleado(){

        try {

            List<Empleado> empleados = empleadoRepositorio.encontrarTodo();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("id");
            model.addColumn("nombre");
            model.addColumn("primerApellido");
            model.addColumn("segundoApellido");
            model.addColumn("email");
            model.addColumn("salario");
                for (Empleado empleado: empleados){

                    Object[] filaDatos = {
                            empleado.getId(),
                            empleado.getNombre(),
                            empleado.getPrimerApellido(),
                            empleado.getSegundoApellido(),
                            empleado.getEmail(),
                            empleado.getSalario()
                    };
                    model.addRow(filaDatos);
                }
            tablaEmpleado.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener datos, por favor verifique", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
