/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.organizacion.dao;

import ec.edu.espe.arquitectura.organizacion.model.OrgUnidad;
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
public class OrgUnidadFacade extends AbstractFacade<OrgUnidad> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.organizacion_Organizacion-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrgUnidadFacade() {
        super(OrgUnidad.class);
    }

    public List<OrgUnidad> obtenerPorNombre(String unidadNombre) {
        Query q = this.em.createQuery("SELECT obj FROM OrgUnidad obj WHERE obj.nombre LIKE :nomBus");
        q.setParameter("nomBus", "%" + unidadNombre + "%");
        return q.getResultList();
    }
}
