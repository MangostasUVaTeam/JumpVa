/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment;

import java.util.Arrays;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import server.api.security.Secured;
import server.model.shipment.Shipment;
import server.model.shipment.ShipmentType;
import server.model.shipment.bid.Bid;
import server.model.shipment.milestone.Milestone;
import server.model.shipment.milestone.MilestoneType;
import server.model.util.Dimens;

/**
 *
 * @author garciparedes
 */
@Path("shipment")
public class ShipmentEndPoint {
    
    @GET
    @Secured()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response signInUser() {
        try {
            
            Shipment shipment = new Shipment(23, ShipmentType.ANIMAL, 
                    "transporte de pollos", 44.4, new Dimens(4243,324,432),
                    "Madrid", "Sevilla", new Date(), new Date(),
                    Arrays.asList(
                        new Milestone(new Date(), MilestoneType.COMMENT, "Coño, un hito"),
                        new Milestone(new Date(), MilestoneType.COMMENT, "Coño, otro hito")
                    ), new Bid("Paco", 34.2),
                    Arrays.asList(new Bid("Paco", 34.2), new Bid("Juan", 354.4))
            );

            
            return Response.ok(shipment).status(Response.Status.CREATED).build();

        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }      
    }
    
    
}
