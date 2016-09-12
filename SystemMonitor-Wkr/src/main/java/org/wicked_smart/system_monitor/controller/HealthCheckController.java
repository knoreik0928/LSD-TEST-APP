package org.wicked_smart.system_monitor.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wicked_smart.system_monitor.model.SystemStatus;
import org.wicked_smart.system_monitor.service.HealthCheckService;
import org.wicked_smart.system_monitor.service.ManifestService;

/**
 * Created by dlahey on 8/15/2016.
 */
@Path("/health")
public class HealthCheckController
{

    private static final Logger LOGGER = LoggerFactory.getLogger(HealthCheckController.class);

    @Context
    private HttpServletRequest request;
    private HealthCheckService healthCheckService;
    private ManifestService manifestService;

    public HealthCheckService getHealthCheckService()
    {
        return healthCheckService;
    }

    @Inject
    public void setHealthCheckService(HealthCheckService healthCheckService)
    {
        LOGGER.info("inject service");
        this.healthCheckService = healthCheckService;
    }

    public ManifestService getManifestService()
    {
        return manifestService;
    }

    @Inject
    public void setManifestService(ManifestService manifestService)
    {
        this.manifestService = manifestService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getManifest()
    {

        return Response.ok().entity(getManifestService().getManifest()).build();
    }


/*
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createQuery(Query query) {

        LOGGER.info("Query Received=" + query);
        Query createdQuery = this.healthCheckService.createQuery(query);
        LOGGER.info("Created Query=" + createdQuery);
        String location = StringUtils.stripEnd(request.getRequestURI(), "/ ") + "/" + createdQuery.getId();
        return Response.created(URI.create(location)).build();
    }
*/

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuery(@PathParam("id") Long id)
    {
        LOGGER.info("Message received id=" + id);
        SystemStatus systemStatus = new SystemStatus();
        systemStatus.setId(1L);
        systemStatus.setName("test");

        return Response.ok().entity(systemStatus).build();
    }

    /*
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateQuery(@PathParam("id") Long id, Query query) {

        Query updatedQuery = this.queryService.updateQuery(id, query);
        if (updatedQuery == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        Response response = Response.noContent().build();
        return response;
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteQuery(@PathParam("id") Long id) {

        this.queryService.deleteQuery(id);
        Response response = Response.noContent().build();
        return response;
    }
    */
}
