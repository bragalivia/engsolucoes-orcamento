package rest;

import business.ComposicoesService;
import com.google.common.net.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.model.Composicao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static helper.ResponseHelper.noContent;
import static helper.ResponseHelper.notFound;

/**
 * Created by Livia on 16/06/2016.
 */
@Path("composicoes")
@Component
public class ComposicoesRest {
    @Autowired
    private ComposicoesService composicoesService;

    @GET
    @Path("{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("code") final int code) {
        Composicao result = composicoesService.read(code);
        if (result == null) {
            return notFound();
        }
        return Response.status(Response.Status.OK)
                .entity(result)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .build();
    }

    @DELETE
    public Response delete(@QueryParam("source") String source, @QueryParam("code") int code) {
        boolean result = composicoesService.delete(source, code);
        if (!result) {
            return notFound();
        }
        return noContent();
    }
}
