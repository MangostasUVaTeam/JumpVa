/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.columns;

import server.model.shipment.milestone.MilestoneType;
import static server.model.shipment.milestone.MilestoneType.valueOf;

/**
 *
 * @author Sergio
 */
public enum ColumnsEnvio {
    NROENVIO,
    EMAIL,
    PESO,
    TIPO,
    DIMENSIONES,
    FENVIO,
    FRECOGIDA,
    DESTINO,
    ORIGEN,
    VALORACION,
    ESTADO;
    
    public ColumnsEnvio fromString(String param) {
        String toUpper = param.toUpperCase();
        try {
            return valueOf(toUpper);
        } catch (Exception e) {
            return null;
        }
    }
    
}
