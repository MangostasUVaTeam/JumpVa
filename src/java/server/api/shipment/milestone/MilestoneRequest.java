/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.shipment.milestone;

import java.io.Serializable;
import server.model.shipment.milestone.Milestone;

/**
 *
 * @author garciparedes
 */
public class MilestoneRequest implements Serializable{
    private String shipmentId;
    private Milestone milestone;

    public MilestoneRequest() {
    }

    public MilestoneRequest(String shipment, Milestone milestone) {
        this.shipmentId = shipment;
        this.milestone = milestone;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Milestone getMilestone() {
        return milestone;
    }

    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

}
