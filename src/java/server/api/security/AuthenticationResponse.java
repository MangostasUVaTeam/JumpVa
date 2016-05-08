package server.api.security;


import java.io.Serializable;
import server.api.token.Token;
import server.model.user.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author garciparedes
 */
public class AuthenticationResponse implements Serializable{
    
    private Token token;
    private User user;
    
    
    public AuthenticationResponse() {
    }
    
    
    public AuthenticationResponse(Token token, User user){
        this.token = token;
        this.user = user;
    }
    
    public void setToken(Token token){
        this.token = token;
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
    public Token getToken(){
        return token;
    }
    
    public User getUser(){
        return user;
    }
    
    
}
