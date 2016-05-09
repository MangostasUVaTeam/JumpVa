/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment.bid;

import java.io.Serializable;
import server.model.shipment.Shipment;
import server.model.shipment.bid.Bid;

/**
 *
 * @author garciparedes
 */
public class BidRequest implements Serializable{
    
    private Bid bid;
    private Shipment shipment;

    

    public BidRequest() {
    }
    
    public BidRequest(Bid bid, Shipment shipment) {
        this.bid = bid;
        this.shipment = shipment;
    }

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
    
    
}
