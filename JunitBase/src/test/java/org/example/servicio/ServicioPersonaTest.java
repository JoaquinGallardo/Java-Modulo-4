package org.example.servicio;

import org.example.modelo.Persona;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class ServicioPersonaTest {
    private final ServicioPersona servicioPersona = new ServicioPersona();
    @Test
    public void testCrearPersona(){

Persona persona = new Persona("Joaquín", "123456789-9");
String respuestaServicio = servicioPersona.crearPersona(persona);
assertEquals("Creada", respuestaServicio);

    }

    @Test
    public void testActualizarPersona(){
        Persona persona = new Persona("Joaquín", "123456789-9");
        String respuestaServicio = servicioPersona.actualizarPersona(persona);
        assertEquals("Persona actualizada", respuestaServicio);


    }

    @Test
    public void testEliminarPersona(){
        Persona persona = new Persona("Joaquín", "123456789-9");
        String respuestaServicio = servicioPersona.eliminarPersona(persona);
        assertEquals("Persona eliminada", respuestaServicio);


    }
@Test
    public void testListarPersonas(){

    Map<String, String> listaPersonas = servicioPersona.listarPersonas();
    assertNotNull(listaPersonas);

}
}