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

    public CraDetalleMalla obtenerPorCodigo(Integer codigo) {
        return this.detalleMallaFacade.find(codigo);
    }

    public void crear(CraDetalleMalla malla) {
        this.detalleMallaFacade.create(malla);
    }

    public void modificar(CraDetalleMalla malla) {
        this.detalleMallaFacade.edit(malla);
    }

    public void eliminar(Integer codigo) {
        CraDetalleMalla malla = this.detalleMallaFacade.find(codigo);
        this.detalleMallaFacade.remove(malla);
    }

    public List<CraDetalleMalla> obtenerPorNombreAsignatura(String nombreAsignatura) {
        return this.detalleMallaFacade.obtenerPorNombreAsignatura(nombreAsignatura);
    }

}
