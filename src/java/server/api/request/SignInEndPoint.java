/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.request;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import server.api.security.Token;
import server.api.security.TokenManager;
import server.model.user.User;

/**
 *
 * @author garciparedes
 */
@Path("signin")
public class SignInEndPoint {
    
    /** Creates a new instance of HelloWorld */
    public SignInEndPoint() {
    }
 
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response signInUser(User newUser) {
        try {
            
            verifyNewUser(newUser);

            
            Token token = new Token(TokenManager.issueToken(newUser.getUsername()));
            return Response.ok(token).status(Response.Status.CREATED).build();

        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }      
    }

    private void verifyNewUser(User user) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
