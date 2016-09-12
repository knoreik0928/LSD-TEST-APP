package org.wicked_smart.system_monitor.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wicked_smart.system_monitor.service.ManifestService;

/**
 * Created by dlahey on 9/12/2016.
 */
@Path("/manifest")
public class ManifestController
{

    private static final Logger LOGGER = LoggerFactory.getLogger(ManifestController.class);

    private ManifestService manifestService;

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
    public Response getManifest() throws JsonProcessingException, IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        String jsonFromMap = null;
        try
        {
            jsonFromMap = mapper.writeValueAsString(getManifestService().getManifest());
        }
        catch (JsonProcessingException e)
        {
            LOGGER.error(e.getMessage(), e);
            throw e;
        }
        catch (IOException e)
        {
            LOGGER.error(e.getMessage(), e);
            throw e;
        }
        return Response.ok().entity(jsonFromMap).build();
    }
}
