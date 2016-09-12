package org.wicked_smart.system_monitor.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


/**
 * Created by dlahey on 3/7/2016.
 */
@Provider
public class EntityNotFoundMapper implements ExceptionMapper< EntityNotFoundException > {

    public Response toResponse( EntityNotFoundException e) {
        return Response.status( Response.Status.NOT_FOUND). build();
    }
}


