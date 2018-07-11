/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.organizacion.dao;

import ec.edu.espe.arquitectura.organizacion.model.CraMalla;
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
public class CraMallaFacade extends AbstractFacade<CraMalla> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.organizacion_Organizacion-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CraMallaFacade() {
        super(CraMalla.class);
    }
    
    public List<CraMalla> obtenerPorNombreCarrera(String carrera) {
        Query q = this.em.createQuery("SELECT obj FROM CraMalla obj WHERE obj.codCarrera.descripcion LIKE :nomBus");
        q.setParameter("nomBus", "%" + carrera + "%");
        return q.getResultList();
    }
    
}
