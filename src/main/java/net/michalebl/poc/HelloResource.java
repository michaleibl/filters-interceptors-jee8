package net.michalebl.poc;

import org.jboss.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("")
public class HelloResource {
    private static final Logger LOGGER = Logger.getLogger(HelloResource.class);

    @GET
    @Path("hello")
    @Produces("text/plain")
    public String hello() {
        LOGGER.info("Hello from resource method! Now let's do the business.");
        return "Hello, World!";
    }

    @POST
    @Path("post")
    @Produces("text/plain")
    public String post(String text) {
        LOGGER.info("Hello from resource method! This is what you send: " + text);
        return "Thank you!";
    }
}