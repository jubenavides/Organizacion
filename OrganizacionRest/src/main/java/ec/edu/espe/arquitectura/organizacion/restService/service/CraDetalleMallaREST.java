/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.organizacion.restService.service;

import ec.edu.espe.arquitectura.organizacion.model.CraDetalleMalla;
import ec.edu.espe.arquitectura.organizacion.service.DetalleMallaService;
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
@Path("/detalleMallas")
public class CraDetalleMallaREST {

    @Inject
    DetalleMallaService detalleMallaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CraDetalleMalla> findAll() {
        return detalleMallaService.obtenerTodos();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CraDetalleMalla findById(@PathParam("id") Integer id) {
        return detalleMallaService.obtenerPorCodigo(id);
    }

    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(CraDetalleMalla detalleMalla) {
        detalleMallaService.crear(detalleMalla);
    }

    @PUT
    @Path("/modificar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, CraDetalleMalla detalleMalla) {
        detalleMallaService.modificar(detalleMalla);
    }

    @DELETE
    @Path("/eliminar/{id}")
    public void remove(@PathParam("id") Integer id) {
        detalleMallaService.eliminar(id);
    }
}
