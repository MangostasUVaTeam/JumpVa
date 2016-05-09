package server.api.security;


import java.io.Serializable;
import server.api.token.Token;
import server.model.user.Role;
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
    
    private String token;
    private String name;
    private Role role;
    
    
    public AuthenticationResponse() {
    }
    
    
    public AuthenticationResponse(Token token, User user){
        this.token = token.getToken();
        this.name = user.getUsername();
        this.role = user.getRole();
    }

    
    public AuthenticationResponse(String token, String name, Role role) {
        this.token = token;
        this.name = name;
        this.role = role;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    
    public void setToken(String token){
        this.token = token;
    }
    
    public String getToken() {
        return token;
    }
    
    
}
