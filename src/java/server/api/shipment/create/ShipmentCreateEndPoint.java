/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment.create;

import database.QueryShipment;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import server.api.security.Secured;
import server.model.shipment.Shipment;
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
    public Response createNewShipment(@Context SecurityContext securityContext, Shipment shipment) {
        try{
            addNewShipment(securityContext.getUserPrincipal().getName(),shipment);
            return Response.ok().status(Response.Status.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    public void addNewShipment(String email, Shipment shipment) throws Exception{
        if(shipment != null) {
            QueryShipment.insertShipment(email, shipment);
            //Agregar al entrada de el nuevo envio a la tabla de envio 
        } else {
            throw new Exception();
        }
    }
}
