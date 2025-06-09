package org.endorodrigo.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.endorodrigo.model.Persona;

import java.util.List;

public class PersonaDao {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    public PersonaDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("HibernatePU");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void listar(){
        String hql = "select p from Persona p";
        Query query = entityManager.createQuery(hql);
        List<Persona> personas = query.getResultList();
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }

    public Persona getPersona(int id){
        return entityManager.find(Persona.class, id);
    }

    public void save(Persona persona){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(persona);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            if(entityManager.getTransaction().isActive()){
                entityManager.close();
            }

        }
    }

    public void update(Persona persona){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(persona);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            if(entityManager.getTransaction().isActive()){
                entityManager.close();
            }
        }
    }

    public void delete(Persona persona){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(persona));
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            if(entityManager.getTransaction().isActive()){
                entityManager.close();
            }
        }
    }
}
