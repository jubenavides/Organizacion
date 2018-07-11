/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.organizacion.restService.service;

import ec.edu.espe.arquitectura.organizacion.model.CraCarrera;
import ec.edu.espe.arquitectura.organizacion.service.CarreraService;
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
@Path("/carreras")
public class CraCarreraREST {

    @Inject
    CarreraService carreraService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CraCarrera> findAll() {
        return carreraService.obtenerTodos();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CraCarrera findById(@PathParam("id") String id) {
        return carreraService.obtenerPorCodigo(id);
    }

    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(CraCarrera carrera) {
        carreraService.crear(carrera);
    }

    @PUT
    @Path("/modificar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, CraCarrera carrera) {
        carreraService.modificar(carrera);
    }

    @DELETE
    @Path("/eliminar/{id}")
    public void remove(@PathParam("id") String id) {
        carreraService.eliminar(id);
    }
    
    @GET
    @Path("/nombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CraCarrera> findByCarrera(@PathParam("nombre") String nombre) {
        return carreraService.obtenerPorNombre(nombre);
    }
    
    @GET
    @Path("/modalidad/{mod}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CraCarrera> findByModality(@PathParam("mod") String mod) {
        return carreraService.obtenerPorModalidad(mod);
    }

    @GET
    @Path("/departamento/nombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CraCarrera> findByDepName(@PathParam("nombre") String nombre) {
        return carreraService.obtenerPorNombreDepartamento(nombre);
    }
    
    @GET
    @Path("/departamento/codigo/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CraCarrera> findByDepCod(@PathParam("codigo") String codigo) {
        return carreraService.obtenerPorCodDepartamento(codigo);
    }

}
