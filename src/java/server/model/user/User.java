/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model.user;

/**
 *
 * @author garciparedes
 */
public class User {
    
    private String username;
    private String password;
    private Role role;
    
    public User(){
        
    }
    
    public Role getRole(){
        return role;
    }
}
