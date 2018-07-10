/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.organizacion.restService.service;

import ec.edu.espe.arquitectura.organizacion.model.OrgUnidad;
import ec.edu.espe.arquitectura.organizacion.service.UnidadService;
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
@Path("/unidad")
public class OrgUnidadREST {

    @Inject
    UnidadService unidadService;

    @GET
    @Path("/unidades")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrgUnidad> getUnidades() {
        return unidadService.obtenerTodos();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public OrgUnidad findById(@PathParam("id") String id) {
        return unidadService.obtenerPorCodigo(id);
    }

    @GET
    @Path("/nombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrgUnidad> findByName(@PathParam("nombre") String nombre) {
        return unidadService.obtenerPorNombre(nombre);
    }

    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(OrgUnidad unidad) {
        unidadService.crear(unidad);
    }

    @PUT
    @Path("/modificar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, OrgUnidad unidad) {
        unidadService.modificar(unidad);
    }

    @DELETE
    @Path("/eliminar/{id}")
    public void remove(@PathParam("id") String id) {
        unidadService.eliminar(id);
    }
}
