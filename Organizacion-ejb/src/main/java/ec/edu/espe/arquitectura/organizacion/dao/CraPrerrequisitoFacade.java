/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.organizacion.dao;

import ec.edu.espe.arquitectura.organizacion.model.CraPrerrequisito;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jolube
 */
@Stateless
public class CraPrerrequisitoFacade extends AbstractFacade<CraPrerrequisito> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.organizacion_Organizacion-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CraPrerrequisitoFacade() {
        super(CraPrerrequisito.class);
    }
    
}
