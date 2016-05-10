/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model.util;

import java.io.Serializable;

/**
 *
 * @author Sergio
 */
public class Weight implements Serializable {
    private double value;
    private WeightType type;
    
    public Weight() {
    }
    
    public Weight(double value, WeightType type) {
        this.value = value;
        this.type = type;
    }
    
    public void setValue(double value) {
        this.value = value;
    }
    
    public void setType(WeightType type) {
        this.type = type;
    }
    
    public double getValue() {
        return value;
    }
    
    public WeightType getType() {
        return type;
    }
}
