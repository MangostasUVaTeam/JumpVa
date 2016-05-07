/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.security;

import server.model.user.Credentials;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("authentication")
public class AuthenticationEndpoint {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(Credentials credentials) {

        try {
            // Authenticate the user using the credentials provided
            authenticate(credentials);

            // Issue a token for the user
            Token token = new Token(TokenManager.issueToken(credentials.getUsername()));
            
            // Return the token on the response
            return Response.ok(token).status(Response.Status.ACCEPTED).build();

        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }      
    }

    private void authenticate(Credentials credentials) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
        
        // TODO Verificar si la cuenta es correcta y sino lanzar una excepcion.
        System.out.println(credentials.getUsername());
        System.out.println(credentials.getPassword());

    }
}