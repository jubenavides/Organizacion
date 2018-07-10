/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.organizacion.service;

import ec.edu.espe.arquitectura.organizacion.dao.CraPrerrequisitoFacade;
import ec.edu.espe.arquitectura.organizacion.model.CraPrerrequisito;
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
public class PrerrequisitoService {

    @EJB
    private CraPrerrequisitoFacade prerrequisitoFacade;

    public List<CraPrerrequisito> obtenerTodos() {
        return this.prerrequisitoFacade.findAll();
    }

    public CraPrerrequisito obtenerPorCodigo(Integer codigo) {
        return this.prerrequisitoFacade.find(codigo);
    }

    public void crear(CraPrerrequisito prerrequsito) {
        this.prerrequisitoFacade.create(prerrequsito);
    }

    public void modificar(CraPrerrequisito prerrequisito) {
        this.prerrequisitoFacade.edit(prerrequisito);
    }

    public void eliminar(Integer codigo) {
        CraPrerrequisito prerrequisito = this.prerrequisitoFacade.find(codigo);
        this.prerrequisitoFacade.remove(prerrequisito);
    }

}
