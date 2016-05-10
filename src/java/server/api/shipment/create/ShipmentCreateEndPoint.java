/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment.create;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import server.api.security.Secured;
import server.model.user.Role;

/**
 *
 * @author serDelg
 */
@Path("create-shipment")
public class ShipmentCreateEndPoint {
    
    @POST
    @Secured({Role.CLIENTE})
    @Produces()
    public Response createNewShipment(@Context SecurityContext securityContext, String shipment) {
        try{
            addNewShipment(shipment);
            return Response.ok().status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    public void addNewShipment(String shipment) throws Exception{
        List<String> shipmentList = new ArrayList();
        shipmentList.add(shipment);
    }
}
