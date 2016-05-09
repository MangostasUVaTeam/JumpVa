/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment.rate;

import server.model.shipment.Shipment;
import server.model.util.Rate;

/**
 *
 * @author Sergio
 */
public class RateRequest {
    
    private Rate rate;
    private Shipment shipment;

    public RateRequest(Rate rate, Shipment shipment) {
        this.rate = rate;
        this.shipment = shipment;
    }

    public RateRequest() {
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
    
}
