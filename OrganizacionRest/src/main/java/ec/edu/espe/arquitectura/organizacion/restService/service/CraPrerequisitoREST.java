/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.organizacion.restService.service;

import ec.edu.espe.arquitectura.organizacion.model.CraPrerequisito;
import ec.edu.espe.arquitectura.organizacion.service.PrerequisitoService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jolube
 */
@Stateless
@Path("/prerequisitos")
public class CraPrerequisitoREST {

    @Inject
    PrerequisitoService prerequisitoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CraPrerequisito> findAll() {
        return prerequisitoService.obtenerTodos();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CraPrerequisito findById(@PathParam("id") Integer id) {
        return prerequisitoService.obtenerPorCodigo(id);
    }

    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(CraPrerequisito prerequisito) {
        prerequisitoService.crear(prerequisito);
    }

    @PUT
    @Path("/modificar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, CraPrerequisito prerequisito) {
        prerequisitoService.modificar(prerequisito);
    }

    @DELETE
    @Path("/eliminar/{id}")
    public void remove(@PathParam("id") Integer id) {
        prerequisitoService.eliminar(id);
    }
}
