/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment.assign;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import server.api.security.Secured;
import server.api.shipment.bid.BidRequest;
import server.model.shipment.ShipmentState;
import server.model.user.Role;
import server.model.user.User;

/**
 *
 * @author garciparedes
 */
@Path("assign-bid")
public class ShipmentAssignEndPoint {
    
    
    @POST
    @Secured({Role.CLIENTE})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response asssignBid(@Context SecurityContext securityContext,
            BidRequest bidRequest) {
        try {
            assignBid(bidRequest);
        
            return Response.status(Response.Status.CREATED).build();

        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }      
    }

    private void assignBid(BidRequest bidRequest) throws Exception{
        if(bidRequest.getBid() != null  /* || El usuario asociado al id de: 
            bidRequest.getBid().getCarrier()*/) {
            //Recuperar el transportista asociado a la puja con la consulta sobre
            // bidRequest.getBid.getCarrier() que devuelve el email del transportista
            //Actualizar los datos del envio con id: bidRequest.getShipmentId() en la base de datos.
        } else {
            //Si no hay una puja puede ser por que el Transportista la haya cancelado.
            throw new Exception();
        }
        
    }
}