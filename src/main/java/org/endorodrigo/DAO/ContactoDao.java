package org.endorodrigo.DAO;

import jakarta.persistence.Query;
import org.endorodrigo.model.Asignacion;
import org.endorodrigo.model.Contacto;

import java.util.List;

public class ContactoDao extends GenericDao{
    public List<Asignacion> listar() {
        String sql = "select d from Contacto d";
        em = getEntityManager();
        Query query = em.createQuery(sql);
        return query.getResultList();
    }

    public void insert(Contacto contacto) {
        try {
            em.getTransaction().begin();
            em.persist(contacto);
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public void update(Contacto contacto) {
        try {
            em.getTransaction().begin();
            em.merge(contacto);
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public void delite(Contacto contacto) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(contacto));
            em.getTransaction().commit();
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }
}
