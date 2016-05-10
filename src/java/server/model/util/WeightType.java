/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model.util;

import static server.model.util.DimensType.valueOf;

/**
 *
 * @author garciparedes
 */
public enum WeightType {
    KILOGRAM,
    TONNE;
    
    public WeightType fromString(String param) {
        String toUpper = param.toUpperCase();
        try {
            return valueOf(toUpper);
        } catch (Exception e) {
            return null;
        }
    }
}