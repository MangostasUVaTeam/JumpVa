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
    
    private String carrierEmail;
    private double offer;
    
    public Bid (){
        
    } 
    
    public Bid (String carrierEmail, double offer){
        this.carrierEmail = carrierEmail;
        this.offer = offer; 
    }

    public String getCarrier() {
        return carrierEmail;
    }

    public void setCarrier(String carrierEmail) {
        this.carrierEmail = carrierEmail;
    }

    public double getOffer() {
        return offer;
    }

    public void setOffer(double offer) {
        this.offer = offer;
    }
}
