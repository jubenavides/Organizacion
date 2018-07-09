/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.organizacion.service;

import ec.edu.espe.arquitectura.organizacion.dao.CraDetalleMallaFacade;
import ec.edu.espe.arquitectura.organizacion.model.CraDetalleMalla;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author jolube
 */
@Stateless
@LocalBean
public class DetalleMallaService {
    
    @EJB
    private CraDetalleMallaFacade detalleMallaFacade;
    
    public List<CraDetalleMalla> obtenerTodos() {
        return this.detalleMallaFacade.findAll();
    }
    
    public CraDetalleMalla obtenerPorCodigoDetalleMalla(Integer codigo) {
        return this.detalleMallaFacade.find(codigo);
    }
    
    public List<CraDetalleMalla> obtenerPorNombre(String nombreAsignatura) {
        return this.detalleMallaFacade.obtenerPorNombreAsignatura(nombreAsignatura);
    }
    
}
