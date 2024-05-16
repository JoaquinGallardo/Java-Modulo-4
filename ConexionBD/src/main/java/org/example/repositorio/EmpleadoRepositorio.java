package org.example.repositorio;
import com.mysql.cj.protocol.Resultset;
import org.example.modelo.Empleado;
import org.example.utilidad.ConexionDb;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepositorio implements Repositorio<Empleado>{
    private Connection obtenerConexion() throws SQLException{

        return ConexionDb.obtenerConexión();

    }

    @Override
    public List<Empleado> encontrarTodo() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        try(
            Connection connection = obtenerConexion();   // conexión a la base de datos
            // Statement permite esablecer el flujo de la conexión a una BD para ejecutar consultas
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from empleados"))
        {
            while (resultSet.next())
            {
             Empleado empleado = crearEmpleado(resultSet);
             empleados.add(empleado);

            }

        }
         return empleados;
    }

    private Empleado crearEmpleado(ResultSet resultSet) throws SQLException {

        Empleado empleado = new Empleado();
        empleado.setId(resultSet.getInt("id"));
        empleado.setNombre(resultSet.getString("nombre"));
        empleado.setPrimerApellido(resultSet.getString("primerApellido"));
        empleado.setSegundoApellido(resultSet.getString("segundoApellido"));
        empleado.setEmail(resultSet.getString("email"));
        empleado.setSalario(resultSet.getFloat("salario"));
        return empleado;
    }

    @Override
    public Empleado obtenerPorId() throws SQLException {
        return null;
    }

    @Override
    public Empleado obtenerPorId(int id) throws SQLException {
        Empleado empleado = null;
        try(
                Connection connection = obtenerConexion();
                PreparedStatement preparedStatement = connection.prepareStatement("select * from empleados where id=?"))
        {
            preparedStatement.setInt(1,id);
            try(

                    ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {

                 empleado = crearEmpleado(resultSet);

                }


            }


        }
        return empleado;
    }



    @Override
    public void guardar(Empleado empleado)  {
          String sql; //
        if(empleado.getId() > 0)
        {

            sql = "update empleados set nombre=?,pimerApellido=?,segundoApellido=?,email=?,salario= where id=?";

        }
        else
        {
            sql = "insert into empleados (nombre, primerApellido, segundoApellido, email, salario)"+
                    " values(?,?,?,?,?)";

        }
        try (
                Connection connection = obtenerConexion();
                PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
                preparedStatement.setString(1,empleado.getNombre());
                preparedStatement.setString(2,empleado.getPrimerApellido());
                preparedStatement.setString(3,empleado.getSegundoApellido());
                preparedStatement.setString(4,empleado.getEmail());
                preparedStatement.setFloat(5,empleado.getSalario());
if (empleado.getId()>0) //el usuario existe, habrá que actualizarlo
{
    preparedStatement.setInt(6,empleado.getId());

}
preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void eliminar(int id) throws SQLException {

        try(
                Connection connection = obtenerConexion();
                PreparedStatement preparedStatement = connection.prepareStatement("delete from empleados where id=?"))

        {

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        }

    }
}
