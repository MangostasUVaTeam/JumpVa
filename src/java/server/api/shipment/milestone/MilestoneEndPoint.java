/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment.milestone;

import database.QueryMilestone;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
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
@Path("post-milestone")
public class MilestoneEndPoint {
    
    
    @POST
    @Secured()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postMilestone(@Context SecurityContext securityContext,
            MilestoneRequest milestoneRequest) {
        try {
            addMilestone(milestoneRequest, securityContext.getUserPrincipal().getName());
            return Response.status(Response.Status.CREATED).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }      
    }

    private void addMilestone(MilestoneRequest milestoneRequest,String username) throws Exception{
      QueryMilestone.addMilestone(Integer.valueOf(milestoneRequest.getShipmentId()), milestoneRequest.getMilestone());
    }
}
