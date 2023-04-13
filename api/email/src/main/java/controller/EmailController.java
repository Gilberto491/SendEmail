package controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/email/send")
public class EmailController {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String sendEmail(String emailTo, String message) {
        return "email para " + emailTo + " enviado com sucesso";
    }
}
