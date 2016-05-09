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
    private double pma;
    private WeightType type;
    
    public Weight() {
    }
    
    public Weight(double pma, WeightType type) {
        this.pma = pma;
        this.type = type;
    }
    
    public void setPma(double pma) {
        this.pma = pma;
    }
    
    public void setType(WeightType type) {
        this.type = type;
    }
    
    public double getPma() {
        return pma;
    }
    
    public WeightType getType() {
        return type;
    }
}
