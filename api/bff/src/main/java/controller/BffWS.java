package controller;

import dto.BffDTO;
import inteface.RestClientInterface;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/send")
public class BffWS {

    @Inject
    @RestClient
    RestClientInterface client;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String send(BffDTO dto) {
        return client.sendEmail(dto.getEmailTo(), dto.getText());
    }
}
