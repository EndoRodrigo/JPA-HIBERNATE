package org.endorodrigo.DAO;

import jakarta.persistence.Query;
import org.endorodrigo.model.Domicilio;

import java.util.List;

public class DomicilioDao extends GenericDao{
    public List listar() {
        String sql = "select d from Domicilio d";
        em = getEntityManager();
        Query query = em.createQuery(sql);
        System.out.println("=== Domicilios ===" + query.getResultList());
        return query.getResultList();
    }

    public void insert(Domicilio domicilio) {
        try {
            em.getTransaction().begin();
            em.persist(domicilio);
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public void update(Domicilio domicilio) {
        try {
            em.getTransaction().begin();
            em.merge(domicilio);
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public void delite(Domicilio domicilio) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(domicilio));
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }
}
