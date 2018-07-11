/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.organizacion.service;

import ec.edu.espe.arquitectura.organizacion.dao.CraCarreraFacade;
import ec.edu.espe.arquitectura.organizacion.model.CraCarrera;
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
public class CarreraService {

    @EJB
    private CraCarreraFacade carreraFacade;

    public List<CraCarrera> obtenerTodos() {
        return this.carreraFacade.findAll();
    }

    public CraCarrera obtenerPorCodigo(String codigo) {
        return this.carreraFacade.find(codigo);
    }

    public void crear(CraCarrera carrera) {
        this.carreraFacade.create(carrera);
    }

    public void modificar(CraCarrera carrera) {
        this.carreraFacade.edit(carrera);
    }

    public void eliminar(String codigo) {
        CraCarrera carrera = this.carreraFacade.find(codigo);
        this.carreraFacade.remove(carrera);
    }
    
    public List<CraCarrera> obtenerPorNombre(String carreraNombre) {
        return this.carreraFacade.obtenerPorNombreCarrera(carreraNombre);
    }

    public List<CraCarrera> obtenerPorNombreDepartamento(String nombreDep) {
        return this.carreraFacade.obtenerPorNombreDepartamento(nombreDep);
    }
    
    public List<CraCarrera> obtenerPorCodDepartamento(String codDepartamento) {
        return this.carreraFacade.obtenerPorCodDepartamento(codDepartamento);
    }
    
     public List<CraCarrera> obtenerPorModalidad(String modalidad) {
        return this.carreraFacade.obtenerPorModalidad(modalidad);
    }
    
}
