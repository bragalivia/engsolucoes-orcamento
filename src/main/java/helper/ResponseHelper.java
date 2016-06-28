/**
 * (C) Copyright 2016 HP Development Company, L.P.
 *
 * Confidential computer software. Valid license from HP required for possession, use or copying.
 * Consistent with FAR 12.211 and 12.212, Commercial Computer Software,
 * Computer Software Documentation, and Technical Data for Commercial Items are licensed
 * to the U.S. Government under vendor's standard commercial license.
 */
package helper;


import javax.ws.rs.core.Response;

import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.SERVICE_UNAVAILABLE;

public class ResponseHelper {
    private ResponseHelper() {
    }

    public static Response notFound() {
        return Response.status(Response.Status.NOT_FOUND)
                .entity("")
                .build();
    }

    public static Response noContent() {
        return Response.status(Response.Status.NO_CONTENT).entity("").build();
    }

    public static Response created(Object object) {
        return Response
                .status(CREATED)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .entity(object)
                .build();
    }

    public static Response unavailable() {
        return Response.status(SERVICE_UNAVAILABLE)
                .entity("")
                .build();
    }
}
