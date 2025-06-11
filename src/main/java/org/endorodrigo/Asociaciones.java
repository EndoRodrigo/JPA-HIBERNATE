package org.endorodrigo;

import org.endorodrigo.DAO.AlumnoDao;
import org.endorodrigo.DAO.DomicilioDao;
import org.endorodrigo.model.Alumno;

import java.util.Arrays;
import java.util.List;

public class Asociaciones {
    public static void main(String[] args) {
        AlumnoDao alumno = new AlumnoDao();
        System.out.println("=== ALUMNOS ===");
        imprimirAlumno(alumno.listar());

        DomicilioDao domicilioDao = new DomicilioDao();
        System.out.println("=== DOMICILIOS ===");
        imprimirAlumno(domicilioDao.listar());

    }

    private static void imprimirAlumno(List collecions) {
        for (Object object : collecions) {
            System.out.println("Valor = " + collecions);
        }
    }
}
