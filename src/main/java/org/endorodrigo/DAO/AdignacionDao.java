package org.endorodrigo.DAO;

import jakarta.persistence.Query;
import org.endorodrigo.model.Asignacion;
import org.endorodrigo.model.Asignacion;

import java.util.List;

public class AdignacionDao extends GenericDao{
    public List<Asignacion> listar() {
        String sql = "select d from Asignacion d";
        em = getEntityManager();
        Query query = em.createQuery(sql);
        return query.getResultList();
    }

    public void insert(Asignacion asignacion) {
        try {
            em.getTransaction().begin();
            em.persist(asignacion);
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public void update(Asignacion asignacion) {
        try {
            em.getTransaction().begin();
            em.merge(asignacion);
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public void delite(Asignacion asignacion) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(asignacion));
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }
}
