/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model.shipment.bid;

import java.io.Serializable;

/**
 *
 * @author garciparedes
 */
public class Bid implements Serializable {
    
    private String carrier;
    private double offer;
    
    public Bid (){
        
    } 
    
    public Bid (String carrier, double offer){
        this.carrier = carrier;
        this.offer = offer; 
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public double getOffer() {
        return offer;
    }

    public void setOffer(double offer) {
        this.offer = offer;
    }
}
