/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment.search.unassigned;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import server.api.security.Secured;
import server.api.shipment.ShipmentResponse;
import server.model.shipment.Shipment;
import server.model.shipment.ShipmentType;
import server.model.shipment.bid.Bid;
import server.model.shipment.milestone.Milestone;
import server.model.shipment.milestone.MilestoneType;
import server.model.user.Role;
import server.model.util.Dimens;
import server.model.util.DimensType;

/**
 *
 * @author garciparedes
 */
@Path("search-unassigned-shipment")
public class ShipmentSearchUnassignedEndPoint {
    
    
    @POST
    @Secured({Role.TRANSPORTISTA})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getShipmentList(ShipmentFilterRequest shipmentFilterRequest) {
        try {           
            return Response.ok(getShipmentFilteredList(shipmentFilterRequest))
                .status(Response.Status.OK).build();

        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }      
    }

    private ShipmentResponse getShipmentFilteredList(ShipmentFilterRequest shipmentFilterRequest) {
        Shipment shipment = new Shipment(23, ShipmentType.ANIMAL, 
                    "transporte de pollos", 44.4, new Dimens(4243,324,432, DimensType.METER),
                    "Madrid", "Sevilla", new Date(), new Date(),
                    Arrays.asList(
                        new Milestone(new Date(), MilestoneType.COMMENT, "Coño, un hito"),
                        new Milestone(new Date(), MilestoneType.COMMENT, "Coño, otro hito")
                    ), new Bid("Paco", 34.2),
                    Arrays.asList(new Bid("Paco", 34.2), new Bid("Juan", 354.4))
            );
            
        Shipment shipment2 = new Shipment(23, ShipmentType.ANIMAL, 
                "transporte de pollos", 44.4, new Dimens(4243,324,432, DimensType.METER),
                "Madrid", "Sevilla", new Date(), new Date(),
                Arrays.asList(
                    new Milestone(new Date(), MilestoneType.COMMENT, "Coño, un hito"),
                    new Milestone(new Date(), MilestoneType.COMMENT, "Coño, otro hito")
                ), new Bid("Paco", 34.2),
                Arrays.asList(new Bid("Paco", 34.2), new Bid("Juan", 354.4))
        );

        List<Shipment> shipmentList = new ArrayList();
        shipmentList.add(shipment);
        shipmentList.add(shipment2);
            
        return new ShipmentResponse(shipmentList);
    }
}
