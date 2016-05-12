/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model.shipment.milestone;

import server.model.shipment.ShipmentType;
import static server.model.shipment.ShipmentType.values;

/**
 *
 * @author garciparedes
 */
public enum MilestoneType {
    COMMENT;
    
    public MilestoneType fromString(String param) {
        String toUpper = param.toUpperCase();
        try {
            return valueOf(toUpper);
        } catch (Exception e) {
            return null;
        }
    }
}
