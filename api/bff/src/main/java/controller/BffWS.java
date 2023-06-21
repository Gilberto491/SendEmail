package controller;

import dto.BffDTO;
import inteface.RestClientInterface;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BffWS {

    @Inject
    @RestClient
    RestClientInterface client;

    @POST
    @Path("/enviar-email")
    public Response send(BffDTO dto) {
        try {
            client.sendEmail(dto);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }

    }
}
