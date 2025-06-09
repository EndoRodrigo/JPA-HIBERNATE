package org.endorodrigo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.endorodrigo.DAO.PersonaDao;
import org.endorodrigo.model.Persona;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        //Instancia para realizar acciones CRUD
        PersonaDao personaDao = new PersonaDao();

        //get
        personaDao.listar();

        //post
        //Persona persona = new Persona("Andrea Jimenez","Ariza Rodriguez","test@gmail.com","13453422");
        //personaDao.salvar(persona);

        //put
        Persona persona = new Persona();
        persona.setId(2);
        persona.setNombre("Juanito");
        persona.setApellido("Juanito");
        persona.setEmail("test@gmail.com");
        persona.setTelefono("12345");
        //personaDao.update(persona);

        //Detele
        personaDao.delete(persona);

        //GET(ID)
        //System.out.println("find user = " + personaDao.getPersona(persona.getId()));

    }
}