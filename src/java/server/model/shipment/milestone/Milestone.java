/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model.shipment.milestone;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author garciparedes
 */
public class Milestone implements Serializable{

    
    private Date date;
    private MilestoneType type;
    private String body;

    public Milestone() {
    }
    
    
    public Milestone(Date date, MilestoneType type, String body) {
        this.date = date;
        this.type = type;
        this.body = body;
    }

    
    
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MilestoneType getType() {
        return type;
    }

    public void setType(MilestoneType type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
}
