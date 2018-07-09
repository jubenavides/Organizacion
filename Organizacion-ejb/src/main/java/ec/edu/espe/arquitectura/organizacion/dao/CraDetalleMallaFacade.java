/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.organizacion.dao;

import ec.edu.espe.arquitectura.organizacion.model.CraDetalleMalla;
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
public class CraDetalleMallaFacade extends AbstractFacade<CraDetalleMalla> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.organizacion_Organizacion-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CraDetalleMallaFacade() {
        super(CraDetalleMalla.class);
    }
    
    public List<CraDetalleMalla> obtenerPorNombreAsignatura(String nombre) {
        Query qry = this.em.createQuery("SELECT obj FROM CraDetalleMalla obj WHERE obj.codAsignatura.nombre LIKE :nomBus");
        qry.setParameter("nomBus", "%" + nombre + "%");
        return qry.getResultList();
    }
    
    
}
