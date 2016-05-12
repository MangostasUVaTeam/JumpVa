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
    private String email;
    private Role role;
    
    
    public AuthenticationResponse() {
    }
    
    
    public AuthenticationResponse(Token token, User user){
        this.token = token.getToken();
        this.email = user.getEmail();
        this.role = user.getRole();
    }

    
    public AuthenticationResponse(String token, String name, Role role) {
        this.token = token;
        this.email = name;
        this.role = role;
    }
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
