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
import server.model.shipment.Shipment;
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
    
    
    public ShipmentResponse getShipmentList(String username){
        System.out.println(username);
        Shipment shipment = new Shipment(23, ShipmentType.ANIMAL, 
                    "transporte de pollos", 44.4, new Dimens(4243,324,432, DimensType.METER),
                    "Madrid", "Sevilla", new Date(), new Date(),
                    Arrays.asList(
                        new Milestone(new Date(), MilestoneType.COMMENT, "Coño, un hito"),
                        new Milestone(new Date(), MilestoneType.COMMENT, "Coño, otro hito")
                    ), new Bid("Paco", 34.2),
                    Arrays.asList(new Bid("Paco", 34.2), new Bid("Juan", 354.4)),
                ShipmentState.INPROGRESS
            );
            
            Shipment shipment2 = new Shipment(23, ShipmentType.ANIMAL, 
                    "transporte de pollos", 44.4, new Dimens(4243,324,432, DimensType.METER),
                    "Madrid", "Sevilla", new Date(), new Date(),
                    Arrays.asList(
                        new Milestone(new Date(), MilestoneType.COMMENT, "Coño, un hito"),
                        new Milestone(new Date(), MilestoneType.COMMENT, "Coño, otro hito")
                    ), new Bid("Paco", 34.2),
                    Arrays.asList(new Bid("Paco", 34.2), new Bid("Juan", 354.4)),
                ShipmentState.INPROGRESS
            );

            List<Shipment> shipmentList = new ArrayList();
            shipmentList.add(shipment);
            shipmentList.add(shipment2);
            
        return new ShipmentResponse(shipmentList);
    }
    
    
}
