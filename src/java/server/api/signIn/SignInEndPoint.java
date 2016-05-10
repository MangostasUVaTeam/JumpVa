/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.signIn;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.eclipse.persistence.jpa.rs.util.JPARSLogger.exception;
import server.api.token.Token;
import server.api.token.TokenManager;
import server.model.user.Role;
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
            
            createNewUser(newUser);

            
            Token token = new Token(TokenManager.issueToken(newUser.getEmail()));
            return Response.ok(token).status(Response.Status.CREATED).build();

        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }      
    }

    private void createNewUser(User user) throws Exception {
        /**if(Email no esta dentro de la base de datos) {
                //Agragegar los datos de "user" a la tabla Usuario
                if(user.getRole() == Role.TRANSPORTISTA) {
                    //Agregar los datos de "user" a la tabla Transportista
                } else {
                    //Agregar los datos de "user" a la tabla Remitente
                }
       } else {
            throw new Exception();
        }*/
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

