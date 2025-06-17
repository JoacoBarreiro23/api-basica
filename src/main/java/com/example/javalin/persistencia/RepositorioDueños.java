package com.example.javalin.persistencia;

import com.example.javalin.modelo.Dueño;
import com.example.javalin.modelo.Mascota;
import com.example.javalin.modelo.Raza;

import java.util.List;

import static java.util.Arrays.asList;

public class RepositorioDueños {

    int IdPersona = 0;;

    public int asignarID(){
        IdPersona = IdPersona + 1;

        return IdPersona;
    }

    public List<Dueño> obtenerTodos() {
        return asList(obtenerJose(), obtenerLuna());
    }

    public Dueño obtenerJose() {
        Dueño jose = new Dueño();
        jose.setNombre("Jose");
        jose.setId(1);
        jose.setPassword("******");

        Mascota felix = new Mascota();
        felix.setNombre("Felix");
        felix.setRaza(Raza.GATO);
        Mascota bob = new Mascota();
        bob.setNombre("Bob");
        bob.setRaza(Raza.GATO);

        jose.setMascotas(asList(felix, bob));
        return jose;
    }

    public Dueño obtenerPersona(String nombre,String contraseña){

        Dueño persona = new Dueño();
        persona.setNombre(nombre);
        persona.setId(asignarID());
        persona.setPassword(contraseña);

        return persona;

    }

    public Dueño obtenerLuna() {
        Dueño jose = new Dueño();
        jose.setNombre("Luna");
        jose.setId(2);
        jose.setPassword("&&&&&&&");

        Mascota mimi = new Mascota();
        mimi.setNombre("Mimi");
        mimi.setRaza(Raza.PERRO);

        jose.setMascotas(asList(mimi));
        return jose;
    }
}
