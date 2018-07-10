/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.organizacion.service;

import ec.edu.espe.arquitectura.organizacion.dao.CraAsignaturaFacade;
import ec.edu.espe.arquitectura.organizacion.model.CraAsignatura;
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
public class AsignaturaService {

    @EJB
    private CraAsignaturaFacade asignaturaFacade;

    public List<CraAsignatura> obtenerTodos() {
        return this.asignaturaFacade.findAll();
    }

    public CraAsignatura obtenerPorCodigo(String codigo) {
        return this.asignaturaFacade.find(codigo);
    }

    public void crear(CraAsignatura asignatura) {
        this.asignaturaFacade.create(asignatura);
    }

    public void modificar(CraAsignatura asignatura) {
        this.asignaturaFacade.edit(asignatura);
    }

    public void eliminar(String codigo) {
        CraAsignatura asignatura = this.asignaturaFacade.find(codigo);
        this.asignaturaFacade.remove(asignatura);
    }

    public List<CraAsignatura> obtenerPorNombreAsignatura(String nombreAsignatura) {
        return this.asignaturaFacade.obtenerPorNombreAsignatura(nombreAsignatura);
    }

}
