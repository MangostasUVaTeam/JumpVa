/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import server.model.user.Credentials;
import server.model.user.User;


public class Query {
    private static final String QUERY = "SELECT * FROM User WHERE EmailAddress = ?";
    
    public static User getUser(Credentials credentials) throws SQLException{
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        ResultSet rs = null;
        
        
        PreparedStatement ps = connection.prepareStatement(QUERY);
        
        ps.setString(1, credentials.getEmail());
        
        rs = ps.executeQuery();
        
        User user = null;
        
        if (rs.next()) {
            user = new User(); 
            //user.setFirstName(rs.getString("FirstName")); 
            //user.setLastName(rs.getString("LastName")); 
            //user.setEmailAddress(rs.getString("EmailAddress"));
        }
        
        rs.close();
        ps.close(); 
        pool.freeConnection(connection);
        return user;

    }
    
}
