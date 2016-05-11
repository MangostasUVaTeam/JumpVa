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
import java.util.List;
import server.model.shipment.Shipment;
import server.model.user.Role;
import server.model.user.User;

/**
 *
 * @author garciparedes
 */
public class QueryShipment {
    private static final String QUERY_SHIPMENT = 
            "SELECT * FROM ENVIO WHERE EMAIL = ?";
    
    
    public static List<Shipment> getShipmentList(String email) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        ResultSet rs = null;
        
        
        PreparedStatement ps = connection.prepareStatement(QUERY_SHIPMENT);
        
        //ps.setString(1, credentials.getEmail());
        //ps.setString(2, credentials.getPassword());
        
        rs = ps.executeQuery();
        
        User user = null;
        
        if (rs.next()) {
            
        }
        
        rs.close();
        ps.close(); 
        pool.freeConnection(connection);
        
        return null;
    }
}
