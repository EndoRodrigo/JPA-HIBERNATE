package org.endorodrigo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.endorodrigo.model.Persona;


public class Main {
    public static void main(String[] args) {

        String hql = "SELECT p FROM Persona p";

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateEjemplo1");

        try (EntityManager em = emf.createEntityManager()) {
            var personas = em.createQuery(hql, Persona.class).getResultList();
            personas.forEach(persona -> System.out.println(" " + persona));
        }
    }
}