/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment;

import java.io.Serializable;
import java.util.List;
import server.model.shipment.Shipment;

/**
 *
 * @author garciparedes
 */
public class ShipmentResponse implements Serializable{
    
    private List<Shipment> shipmentList;

    public List<Shipment> getShipmentList() {
        return shipmentList;
    }

    public void setShipmentList(List<Shipment> shipmentList) {
        this.shipmentList = shipmentList;
    }

    public ShipmentResponse(List<Shipment> shipmentList) {
        this.shipmentList = shipmentList;
    }

    public ShipmentResponse() {
    }
}
