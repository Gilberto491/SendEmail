package inteface;

import dto.BffDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://localhost:8081")
public interface RestClientInterface {

    @POST
    @Path("/sending-email")
    @Produces(MediaType.APPLICATION_JSON)
    String sendEmail(BffDTO dto);
}
