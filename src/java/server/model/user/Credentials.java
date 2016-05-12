/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model.user;

import java.io.Serializable;

public class Credentials implements Serializable {

    private String email;
    private String password;
    
    
    public Credentials(){ 
    }

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}