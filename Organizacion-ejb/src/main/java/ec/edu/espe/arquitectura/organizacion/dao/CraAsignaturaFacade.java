/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.organizacion.dao;

import ec.edu.espe.arquitectura.organizacion.model.CraAsignatura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jolube
 */
@Stateless
public class CraAsignaturaFacade extends AbstractFacade<CraAsignatura> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.organizacion_Organizacion-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CraAsignaturaFacade() {
        super(CraAsignatura.class);
    }
    
     public List<CraAsignatura> obtenerPorNombreAsignatura(String nombreAsignatura) {
        Query q = this.em.createQuery("SELECT obj FROM CraAsignatura obj WHERE obj.nombre LIKE :nomBus");
        q.setParameter("nomBus", "%" + nombreAsignatura + "%");
        return q.getResultList();
    }
}
