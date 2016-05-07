/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model.user;

import java.io.Serializable;

/**
 *
 * @author garciparedes
 */
public class User implements Serializable{
    
    private Credentials credentials;
    private Role role;
    
    public User(){   
    }
    
    
    public void setPassword(String password){
        if (getCredentials() == null){
            this.credentials = new Credentials();
        }
        getCredentials().setPassword(password);
    }
    
    
    public void setUsername(String username){
        if (getCredentials() == null){
            this.credentials = new Credentials();
        }
        getCredentials().setUsername(username);
    }
    
    private Credentials getCredentials() {
        return credentials;
    }
    
    public String getPassword(){
        return getCredentials().getPassword();
    }
    
    public String getUsername(){
        return getCredentials().getUsername();
    }
    
    
    public Role getRole(){
        return role;
    }



}
