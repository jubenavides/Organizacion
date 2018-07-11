/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.organizacion.restService.service;

import ec.edu.espe.arquitectura.organizacion.model.CraMalla;
import ec.edu.espe.arquitectura.organizacion.service.MallaService;
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
@Path("/mallas")
public class CraMallaREST {

    @Inject
    MallaService mallaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CraMalla> findAll() {
        return mallaService.obtenerTodos();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CraMalla findById(@PathParam("id") String id) {
        return mallaService.obtenerPorCodigo(id);
    }

    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(CraMalla carrera) {
        mallaService.crear(carrera);
    }

    @PUT
    @Path("/modificar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, CraMalla carrera) {
        mallaService.modificar(carrera);
    }

    @DELETE
    @Path("/eliminar/{id}")
    public void remove(@PathParam("id") String id) {
        mallaService.eliminar(id);
    }

    @GET
    @Path("/carrera/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CraMalla> findByCarrera(@PathParam("nombre") String nombre) {
        return mallaService.obtenerPorNombreCarrera(nombre);
    }
}
