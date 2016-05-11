/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.security;

import database.QueryUser;
import java.sql.SQLException;
import server.api.token.Token;
import server.api.token.TokenManager;
import server.model.user.Credentials;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import server.model.user.Role;
import server.model.user.User;

@Path("authentication")
public class AuthenticationEndpoint {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(Credentials credentials) {

        try {
            // Authenticate the user using the credentials provided
            User user = authenticate(credentials);
            // Issue a token for the user
            Token token = new Token(TokenManager.issueToken(credentials.getEmail()));
            
            // Return the token on the response
            return Response.ok(new AuthenticationResponse(token, user))
                    .status(Response.Status.ACCEPTED).build();
            
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }      
    }

    private User authenticate(Credentials credentials) throws Exception {
       /** if(Consulta si existe un Usuario con nombre credentials.getUser() 
         * y passwd credentials.getPassword()) {
            //Recuperar el usuario y devolverlo
        } else {
            throw new Exception();
        }*/
        try{
             return QueryUser.getUser(credentials); 
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}