/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import server.api.security.Secured;
import server.model.shipment.ShipmentState;
import server.model.shipment.ShipmentType;
import server.model.shipment.bid.Bid;
import server.model.shipment.milestone.Milestone;
import server.model.shipment.milestone.MilestoneType;
import server.model.util.Dimens;
import server.model.util.DimensType;

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
            return Response.status(Response.Status.BAD_REQUEST).build();
        }      
    }
    
    
    public ShipmentResponse getShipmentList(String email) throws Exception {
        //Devolver la lista de los envios asociados a un usuario
       // if(/**Existe el usuario asociado al email*/) {
            //Consultar por todos sus envios, meterlos en una lista
            // y devolverlos
        return new ShipmentResponse();
        //} else {
        //}

    }
    
    
}
