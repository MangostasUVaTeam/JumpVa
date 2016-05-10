/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment.search.unassigned;

import java.io.Serializable;

/**
 *
 * @author garciparedes
 */
public class ShipmentFilterRequest implements Serializable{
    private String origin;

    
    public ShipmentFilterRequest() {
    }


    public ShipmentFilterRequest(String origin) {
        this.origin = origin;
    }

    
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
}
