/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment.rate;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import server.api.security.Secured;
import server.model.user.Role;
import server.model.util.Rate;

/**
 *
 * @author garciparedes
 */
@Path ("rate-shipment")
public class RateEndPoint {
    
    @POST
    @Secured({Role.CLIENTE})
    @Produces()
    public Response rateShipment(@Context SecurityContext securityContext, RateRequest rateRequest) {
        try {
            addRate(rateRequest);
            return Response.ok().status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    public void addRate(RateRequest rateRequest) {
        //rateRequest.getShipmentId().setRate(rateRequest.getRate());
    }
}
