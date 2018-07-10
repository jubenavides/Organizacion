/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.organizacion.service;

import ec.edu.espe.arquitectura.organizacion.dao.OrgUnidadFacade;
import ec.edu.espe.arquitectura.organizacion.model.OrgUnidad;
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
public class UnidadService {

    @EJB
    private OrgUnidadFacade unidadFacade;

    public List<OrgUnidad> obtenerTodos() {
        return this.unidadFacade.findAll();
    }

    public OrgUnidad obtenerPorCodigo(String codigo) {
        return this.unidadFacade.find(codigo);
    }

    public void crear(OrgUnidad unidad) {
        this.unidadFacade.create(unidad);
    }

    public void modificar(OrgUnidad unidad) {
        this.unidadFacade.edit(unidad);
    }

    public void eliminar(String codigo) {
        OrgUnidad unidad = this.unidadFacade.find(codigo);
        this.unidadFacade.remove(unidad);
    }
    
    public List<OrgUnidad> obtenerPorNombre(String unidadNombre) {
        return this.unidadFacade.obtenerPorNombre(unidadNombre);
    }

}
