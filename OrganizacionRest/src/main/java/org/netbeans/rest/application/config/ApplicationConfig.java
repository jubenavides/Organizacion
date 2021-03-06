/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author jolube
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ec.edu.espe.arquitectura.filter.ResponseCorsFilter.class);
        resources.add(ec.edu.espe.arquitectura.organizacion.restService.service.CraAsignaturaREST.class);
        resources.add(ec.edu.espe.arquitectura.organizacion.restService.service.CraCarreraREST.class);
        resources.add(ec.edu.espe.arquitectura.organizacion.restService.service.CraDetalleMallaREST.class);
        resources.add(ec.edu.espe.arquitectura.organizacion.restService.service.CraMallaREST.class);
        resources.add(ec.edu.espe.arquitectura.organizacion.restService.service.CraPrerequisitoREST.class);
        resources.add(ec.edu.espe.arquitectura.organizacion.restService.service.OrgDepartamentoREST.class);
        resources.add(ec.edu.espe.arquitectura.organizacion.restService.service.OrgUnidadREST.class);
    }
    
}
