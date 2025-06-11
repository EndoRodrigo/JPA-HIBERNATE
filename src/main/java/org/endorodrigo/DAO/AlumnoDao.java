package org.endorodrigo.DAO;

import jakarta.persistence.Query;
import org.endorodrigo.model.Asignacion;
import org.endorodrigo.model.Alumno;

import java.util.List;

public class AlumnoDao extends GenericDao{
    public List<Asignacion> listar() {
        String sql = "select d from Alumno d";
        em = getEntityManager();
        Query query = em.createQuery(sql);
        return query.getResultList();
    }

    public void insert(Alumno alumno) {
        try {
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public void update(Alumno alumno) {
        try {
            em.getTransaction().begin();
            em.merge(alumno);
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public void delite(Alumno alumno) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(alumno));
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }
}
