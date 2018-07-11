/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.organizacion.service;

import ec.edu.espe.arquitectura.organizacion.dao.CraPrerequisitoFacade;
import ec.edu.espe.arquitectura.organizacion.model.CraPrerequisito;
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
public class PrerequisitoService {

    @EJB
    private CraPrerequisitoFacade prerrequisitoFacade;

    public List<CraPrerequisito> obtenerTodos() {
        return this.prerrequisitoFacade.findAll();
    }

    public CraPrerequisito obtenerPorCodigo(Integer codigo) {
        return this.prerrequisitoFacade.find(codigo);
    }

    public void crear(CraPrerequisito prerrequsito) {
        this.prerrequisitoFacade.create(prerrequsito);
    }

    public void modificar(CraPrerequisito prerrequisito) {
        this.prerrequisitoFacade.edit(prerrequisito);
    }

    public void eliminar(Integer codigo) {
        CraPrerequisito prerrequisito = this.prerrequisitoFacade.find(codigo);
        this.prerrequisitoFacade.remove(prerrequisito);
    }

}
