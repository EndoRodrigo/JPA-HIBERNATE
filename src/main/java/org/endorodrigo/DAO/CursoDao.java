package org.endorodrigo.DAO;

import jakarta.persistence.Query;
import org.endorodrigo.model.Asignacion;
import org.endorodrigo.model.Curso;

import java.util.List;

public class CursoDao extends GenericDao{
    public List<Asignacion> listar() {
        String sql = "select d from Curso d";
        em = getEntityManager();
        Query query = em.createQuery(sql);
        return query.getResultList();
    }

    public void insert(Curso curso) {
        try {
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public void update(Curso curso) {
        try {
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public void delite(Curso curso) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(curso));
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }
}
