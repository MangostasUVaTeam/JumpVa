package server.api.request;

import server.api.security.Secured;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import server.user.Role;
 
/**
 * Root resource (exposed at "helloworld" path)
 */
@Path("helloworld")
public class HelloWorld {
    @Context
    private UriInfo context;
 
    /** Creates a new instance of HelloWorld */
    public HelloWorld() {
    }
 
    /**
     * Retrieves representation of an instance of helloWorld.HelloWorld
     * @param securityContext
     * @return an instance of java.lang.String
     */
    @GET
    @Secured({Role.CLIENTE, Role.TRANSPORTISTA})
    @Produces("text/html")
    public String getHtml(@Context SecurityContext securityContext) {
        
        return "<html lang=\"en\"><body><h1>Hello, " + 
                securityContext.getUserPrincipal().getName() + 
                "!!</h1></body></html>";
    }
}