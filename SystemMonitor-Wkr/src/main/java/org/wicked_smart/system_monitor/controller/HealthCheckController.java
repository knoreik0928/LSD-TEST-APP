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
}
