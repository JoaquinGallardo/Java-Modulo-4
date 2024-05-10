package org.example.servicio;

import org.example.modelo.Persona;

import java.util.HashMap;
import java.util.Map;

public class ServicioPersona {

    private Map<String, String> personasDb = new HashMap<>();

    public String crearPersona(Persona persona) {

        if (persona != null) {

            personasDb.put(persona.getRut(), persona.getNombre());
            return "Creada";
        } else   {

            return "Persona no creada, verifiqe los datos";

        }


    }

    public String actualizarPersona(Persona persona){

        if (persona != null) {

            personasDb.put(persona.getRut(), persona.getNombre());
            return "Persona actualizada";
        } else   {

            return "Persona no actualizada, verifiqe los datos";

        }

    }

    public Map<String, String> listarPersonas(){

        return personasDb;

    }

    public String eliminarPersona(Persona persona){

        if (persona != null) {

            personasDb.remove(persona.getRut());

            return "Persona eliminada";
        } else   {

            return "Persona no eliminada, verifique los datos";

        }


    }



}
