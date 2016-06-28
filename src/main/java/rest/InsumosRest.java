package rest;

import business.InsumosService;
import com.google.common.net.HttpHeaders;

import javax.ws.rs.*;

import org.springframework.beans.factory.annotation.Autowired;
import rest.model.Insumo;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static helper.ResponseHelper.noContent;
import static helper.ResponseHelper.notFound;

/**
 * Created by Livia on 16/06/2016.
 */
@Path("locks")
public class InsumosRest {
    @Autowired
    InsumosService insumosService;

    @GET
    @Path("{insumoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("insumoId") final String insumoId) {
        Insumo result = insumosService.read(insumoId);
        if (result == null) {
            return notFound();
        }

        return Response.status(Response.Status.OK)
                .entity(result)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .build();
    }

    @DELETE
    public Response delete(@QueryParam("origem") String origem, @QueryParam("insumoId") int insumoId) {
        boolean result = insumosService.delete(origem, insumoId);
        if (!result) {
            return notFound();
        }
        return noContent();
    }
}
