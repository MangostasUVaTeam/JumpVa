/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment;

import database.QueryShipment;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import server.api.security.Secured;

/**
 *
 * @author garciparedes
 */
@Path("shipment")
public class ShipmentEndPoint {
    
    @GET
    @Secured()
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllShipmentList(@Context SecurityContext securityContext) {
        try {
            return Response.ok(getShipmentList(securityContext.getUserPrincipal().getName()))
                .status(Response.Status.OK).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }      
    }
    
    
    public ShipmentResponse getShipmentList(String email) throws Exception {
        //Devolver la lista de los envios asociados a un usuario
       // if(/**Existe el usuario asociado al email*/) {
            //Consultar por todos sus envios, meterlos en una lista
            // y devolverlos
         //} else {
        //}
        return new ShipmentResponse(QueryShipment.getShipmentList(email));
    }
    
    
}
