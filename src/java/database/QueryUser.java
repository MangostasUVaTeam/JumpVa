/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.columns.ColumnsUsuario;
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
            user.setBirthday(
                    rs.getDate(ColumnsUsuario.FNAC.toString())
            );
            user.setAddress(
                    rs.getString(ColumnsUsuario.LOCALIZACION.toString())
            );
            
            return getCarrier(user);
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
                

        if (rs.next()) {
            user.setRole(Role.TRANSPORTISTA);

            //user.setLicenseNo(rs.getString("FirstName")); 
            //user.setWeight(rs.getString("LastName")); 
            //user.setEmailAddress(rs.getString("EmailAddress"));
        } else {
            user.setRole(Role.CLIENTE);
        }
        
        rs.close();
        ps.close(); 
        pool.freeConnection(connection);
        return user;

    }
    
    
    protected static Role getRole(String email) throws SQLException{
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        ResultSet rs = null;
        
        
        PreparedStatement ps = connection.prepareStatement(QUERY_CARRIER);
        ps.setString(1, email);
        rs = ps.executeQuery();
                
        Role role;
        if (rs.next()) {
            role =  (Role.TRANSPORTISTA);
        } else {
            role = (Role.CLIENTE);
        }
        rs.close();
        ps.close(); 
        pool.freeConnection(connection);
        return role;
    }
}


