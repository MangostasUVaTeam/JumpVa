/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.api;

import java.io.Serializable;

public class Credentials implements Serializable {

    private String username;
    private String password;
    
    
    public Credentials(){ 
    }


    private void setUsername(String username){
        this.username = username;
    }
    
    private void setPassword(String password){
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}