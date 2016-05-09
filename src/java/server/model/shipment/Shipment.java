/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model.shipment;

import server.model.util.Dimens;
import server.model.shipment.bid.Bid;
import server.model.shipment.milestone.Milestone;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import server.model.util.Rate;

/**
 *
 * @author garciparedes
 */
public class Shipment implements Serializable{
   
    private int id;
    
    private ShipmentType type;
    private String description;
    
    private double weight;

    
    private Dimens dimens;
    
    private String origin;
    private String destination;
    
    private Date pickUpDate;
    private Date arrivalDate;
    
    private List<Milestone> milestoneList;
    
    private Bid assignedBid;
    private List<Bid> bidList;
    
    private Rate rate;
    
    
    
    public Shipment() {
    }


    public Shipment(int id, ShipmentType type, String description,double weight,
            Dimens dimens, String origin, String destination, Date pickUpDate,
            Date arrivalDate, List<Milestone> milestoneList, Bid assignedBid,
            List<Bid> bidList) {
        
        this.id = id;
        this.type = type;
        this.description = description;
        this.weight = weight;
        this.dimens = dimens;
        this.origin = origin;
        this.destination = destination;
        this.pickUpDate = pickUpDate;
        this.arrivalDate = arrivalDate;
        this.milestoneList = milestoneList;
        this.assignedBid = assignedBid;
        this.bidList = bidList;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ShipmentType getType() {
        return type;
    }

    public void setType(ShipmentType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Dimens getDimens() {
        return dimens;
    }

    public void setDimens(Dimens dimens) {
        this.dimens = dimens;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public List<Milestone> getMilestoneList() {
        return milestoneList;
    }

    public void setMilestoneList(List<Milestone> milestoneList) {
        this.milestoneList = milestoneList;
    }

    public Bid getAssignedBid() {
        return assignedBid;
    }

    public void setAssignedBid(Bid assignedBid) {
        this.assignedBid = assignedBid;
    }

    public List<Bid> getBidList() {
        return bidList;
    }

    public void setBidList(List<Bid> bidList) {
        this.bidList = bidList;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }
    
}
