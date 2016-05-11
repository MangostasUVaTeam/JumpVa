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
import server.model.user.Role;
import server.model.user.User;


public class QueryUser {
    
    private static final String QUERY_USER = 
            "SELECT * FROM USUARIO WHERE EMAIL = ? AND CONTRASENIA  = ?";
    
    private static final String QUERY_CARRIER = 
            "SELECT * FROM TRANSPORTISTA WHERE EMAIL = ?";
    
    public static User getUser(Credentials credentials) throws SQLException{
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        ResultSet rs = null;
        
        
        PreparedStatement ps = connection.prepareStatement(QUERY_USER);
        
        ps.setString(1, credentials.getEmail());
        ps.setString(2, credentials.getPassword());
        
        rs = ps.executeQuery();
        
        User user = null;
        
        if (rs.next()) {
            user = new User();
            user.setCredentials(credentials);
            user.setBirthday(rs.getDate("FNAC"));
            user.setAddress(rs.getString("LOCALIZACION"));
            
            try {
                return getCarrier(user);
            } catch (SQLException e){
                user.setRole(Role.CLIENTE);
                return user;
            }
        }
        
        rs.close();
        ps.close(); 
        pool.freeConnection(connection);
        return user;

    }
    
    private static User getCarrier(User user) throws SQLException{
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        ResultSet rs = null;
        
        
        PreparedStatement ps = connection.prepareStatement(QUERY_CARRIER);
        
        ps.setString(1, user.getEmail());
        
        rs = ps.executeQuery();
                
        user.setRole(Role.TRANSPORTISTA);

        if (rs.next()) {
            //user.setLicenseNo(rs.getString("FirstName")); 
            //user.setWeight(rs.getString("LastName")); 
            //user.setEmailAddress(rs.getString("EmailAddress"));
        }
        
        rs.close();
        ps.close(); 
        pool.freeConnection(connection);
        return user;

    }
}


