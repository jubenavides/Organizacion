/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.organizacion.restService.service;

import ec.edu.espe.arquitectura.organizacion.model.CraAsignatura;
import ec.edu.espe.arquitectura.organizacion.service.AsignaturaService;
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
@Path("/asignaturas")
public class CraAsignaturaREST {

    @Inject
    AsignaturaService asignaturaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CraAsignatura> findAll() {
        return asignaturaService.obtenerTodos();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CraAsignatura findById(@PathParam("id") String id) {
        return asignaturaService.obtenerPorCodigo(id);
    }

    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(CraAsignatura asignatura) {
        asignaturaService.crear(asignatura);
    }

    @PUT
    @Path("/modificar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, CraAsignatura asignatura) {
        asignaturaService.modificar(asignatura);
    }

    @DELETE
    @Path("/eliminar/{id}")
    public void remove(@PathParam("id") String id) {
        asignaturaService.eliminar(id);
    }

    @GET
    @Path("/nombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CraAsignatura> findByName(@PathParam("nombre") String nombre) {
        return asignaturaService.obtenerPorNombreAsignatura(nombre);
    }
}
