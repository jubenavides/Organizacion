/*
 * Universidad Core
 * Arquitectura de software
 * NRC: 3747 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Universidad Core.
 */
package ec.edu.espe.arquitectura.organizacion.service;

import ec.edu.espe.arquitectura.organizacion.dao.OrgDepartamentoFacade;
import ec.edu.espe.arquitectura.organizacion.model.OrgDepartamento;
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
public class DepartamentoService {

    @EJB
    private OrgDepartamentoFacade departamentoFacade;

    public List<OrgDepartamento> obtenerTodos() {
        return this.departamentoFacade.findAll();
    }

    public OrgDepartamento obtenerPorCodigo(String codigo) {
        return this.departamentoFacade.find(codigo);
    }

    public void crear(OrgDepartamento departamento) {
        this.departamentoFacade.create(departamento);
    }

    public void modificar(OrgDepartamento departamento) {
        this.departamentoFacade.edit(departamento);
    }

    public void eliminar(String codigo) {
        OrgDepartamento departamento = this.departamentoFacade.find(codigo);
        this.departamentoFacade.remove(departamento);
    }
    
     public List<OrgDepartamento> obtenerPorNombre(String departamentoNombre) {
        return this.departamentoFacade.obtenerPorNombre(departamentoNombre);
    }
}
