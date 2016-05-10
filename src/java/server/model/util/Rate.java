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
public class Rate  implements Serializable{
    private int value;

    public Rate() {
        this.value = 0;
    }
    
    
    
    public Rate(int value) throws Exception {
        if(value >= 5 || value <= 0) {
            throw new ExceptionInInitializerError();
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) throws Exception {
        if(value >= 5 || value <= 0) {
            throw new Exception();
        }
        this.value = value;
    }
    
}
