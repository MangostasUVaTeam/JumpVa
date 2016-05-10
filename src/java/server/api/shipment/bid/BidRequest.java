/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment.bid;

import java.io.Serializable;
import server.model.shipment.bid.Bid;

/**
 *
 * @author garciparedes
 */
public class BidRequest implements Serializable{
    
    private Bid bid;
    private String shipmentId;

    

    public BidRequest() {
    }
    
    public BidRequest(Bid bid, String shipmentId) {
        this.bid = bid;
        this.shipmentId = shipmentId;
    }

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }
    
    
}
