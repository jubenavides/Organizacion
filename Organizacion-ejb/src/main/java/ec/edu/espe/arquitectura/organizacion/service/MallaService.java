/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.organizacion.service;

import ec.edu.espe.arquitectura.organizacion.dao.CraMallaFacade;
import ec.edu.espe.arquitectura.organizacion.model.CraMalla;
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
public class MallaService {

    @EJB
    private CraMallaFacade mallaFacade;

    public List<CraMalla> obtenerTodos() {
        return this.mallaFacade.findAll();
    }

    public CraMalla obtenerPorCodigo(String codigo) {
        return this.mallaFacade.find(codigo);
    }

    public void crear(CraMalla malla) {
        this.mallaFacade.create(malla);
    }

    public void modificar(CraMalla malla) {
        this.mallaFacade.edit(malla);
    }

    public void eliminar(String codigo) {
        CraMalla malla = this.mallaFacade.find(codigo);
        this.mallaFacade.remove(malla);
    }
    
     public List<CraMalla> obtenerPorNombreCarrera(String carrera) {
        return this.mallaFacade.obtenerPorNombreCarrera(carrera);
    }
    
}
