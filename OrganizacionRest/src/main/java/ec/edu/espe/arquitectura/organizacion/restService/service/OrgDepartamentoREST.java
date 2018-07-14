/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.organizacion.restService.service;

import ec.edu.espe.arquitectura.organizacion.model.OrgDepartamento;
import ec.edu.espe.arquitectura.organizacion.service.DepartamentoService;
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
@Path("/departamentos")
public class OrgDepartamentoREST {

    @Inject
    DepartamentoService departamentoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrgDepartamento> findAll() {
        return departamentoService.obtenerTodos();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public OrgDepartamento findById(@PathParam("id") String id) {
        return departamentoService.obtenerPorCodigo(id);
    }

    @GET
    @Path("/nombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrgDepartamento> findByName(@PathParam("nombre") String nombre) {
        return departamentoService.obtenerPorNombre(nombre);
    }

    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(OrgDepartamento departamento) {
        departamentoService.crear(departamento);
    }

    @PUT
    @Path("/modificar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, OrgDepartamento departamento) {
        departamentoService.modificar(departamento);
    }

    @DELETE
    @Path("/eliminar/{id}")
    public void remove(@PathParam("id") String id) {
        departamentoService.eliminar(id);
    }
}
