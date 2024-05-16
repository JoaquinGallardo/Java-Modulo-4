package org.example.repositorio;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio <T>

{

    List<T> encontrarTodo() throws SQLException;

    T obtenerPorId() throws SQLException;
    T obtenerPorId(int id) throws SQLException;
void guardar(T t);
void eliminar(int id) throws SQLException;


}
