/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api.token;

import java.io.Serializable;

/**
 *
 * @author garciparedes
 */
public class Token implements Serializable {
    
    private String token;
    
    
    public Token (){
    }
    
    
    public Token (String token){
        this.token = token;
    }
    
    public String getToken(){
        return token;
    }
    
    
    public void setToken(String token){
        this.token = token;
    }
    
}
