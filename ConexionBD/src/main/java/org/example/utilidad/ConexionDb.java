package org.example.utilidad;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;



public class ConexionDb {

    static int puerto = 3310;
    static String nombreBd = "tienda-e";

    private final static String URL =
            "jdbc:mysql://localhost:"+puerto+"/"+nombreBd;

    private static String usuario="root";
    private static String pass="caco4269" ;
    private static BasicDataSource pool;

    //metodos

    public static BasicDataSource obtenerPool()throws SQLException {

        if(pool==null){

            pool= new BasicDataSource();
            pool.setUrl(URL); // envía URL como ruta de acceso
            pool.setUsername(usuario); // enviar usuario de la base de datos
            pool.setPassword(pass); // enviar password usuario BD
            pool.setInitialSize(3); // establece el flujo y el valor de los parámetros iniciales de los datos que se recibirán
            pool.setMinIdle(3); // establece tiempo mínimo de espera
            pool.setMaxIdle(10); // establece tiempo máximo de espera
        }
        return pool;

    }

    public static Connection obtenerConexión() throws SQLException{

return obtenerPool().getConnection(); // retornar una conexión.
    }

}
