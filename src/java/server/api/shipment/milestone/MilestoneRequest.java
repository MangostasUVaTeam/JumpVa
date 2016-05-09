/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment.milestone;

import java.io.Serializable;
import server.model.shipment.Shipment;
import server.model.shipment.milestone.Milestone;

/**
 *
 * @author garciparedes
 */
public class MilestoneRequest implements Serializable{
    private Shipment shipment;
    private Milestone milestone;

    public MilestoneRequest() {
    }

    public MilestoneRequest(Shipment shipment, Milestone milestone) {
        this.shipment = shipment;
        this.milestone = milestone;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Milestone getMilestone() {
        return milestone;
    }

    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

}
