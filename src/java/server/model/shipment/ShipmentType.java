/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model.shipment;

/**
 *
 * @author garciparedes
 */
public enum ShipmentType {
    ANIMAL,
    PACKAGE,
    FLUID,
    VEHICLE,
    BULK;
    
    public ShipmentType fromString(String param) {
        String toUpper = param.toUpperCase();
        try {
            return valueOf(toUpper);
        } catch (Exception e) {
            return null;
        }
    }
}
