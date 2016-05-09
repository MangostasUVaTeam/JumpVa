/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment.bid;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import server.api.security.Secured;
import server.model.user.Role;

/**
 *
 * @author garciparedes
 */
@Path("post-bid")
public class BidEndPoint {
    
    
    @POST
    @Secured({Role.TRANSPORTISTA})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postBid(@Context SecurityContext securityContext,
            BidRequest bidRequest) {
        try {
            addBid(bidRequest);
            return Response.status(Response.Status.CREATED).build();

        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }      
    }

    private void addBid(BidRequest bidRequest) throws Exception{
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
