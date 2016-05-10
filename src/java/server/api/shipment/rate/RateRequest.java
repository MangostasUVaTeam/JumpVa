/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment.rate;

import server.model.util.Rate;

/**
 *
 * @author Sergio
 */
public class RateRequest {
    
    private Rate rate;
    private String shipmentId;

    public RateRequest(Rate rate, String shipment) {
        this.rate = rate;
        this.shipmentId = shipment;
    }

    public RateRequest() {
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }
    
}
