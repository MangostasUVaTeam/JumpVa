/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.columns.ColumnsPuja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import server.model.shipment.bid.Bid;

/**
 *
 * @author garciparedes
 */
public class QueryBid {
    
    private static final String QUERY_BID = 
            "SELECT * FROM PUJA WHERE PUJA.NROENVIO = ? AND PUJA.ACEPTADO = 't'";
    
    private static final String QUERY_BIDLIST = 
            "SELECT * FROM PUJA WHERE PUJA.NROENVIO = ?";
    
    protected static List<Bid> getBidList(int shipmentId) throws SQLException{
ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        PreparedStatement ps = connection.prepareStatement(QUERY_BIDLIST);
        
        ps.setInt(1, shipmentId);
        
        ResultSet rs = ps.executeQuery();
        
        List<Bid> bidList = new ArrayList();
        Bid bid;
        if (rs.next()) {
            bid = new Bid(
                    rs.getString(ColumnsPuja.EMAIL.toString()),
                    rs.getDouble(ColumnsPuja.OFERTA.toString())
            );
            bidList.add(bid);
        }
        
        rs.close();
        ps.close(); 
        pool.freeConnection(connection);
        return bidList; 
    }
    
    protected static Bid getAssignedBid(int shipmentId) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        PreparedStatement ps = connection.prepareStatement(QUERY_BID);
        
        ps.setInt(1, shipmentId);
        
        ResultSet rs = ps.executeQuery();
        
        Bid bid = null;
        if (rs.next()) {
            bid = new Bid(
                    rs.getString(ColumnsPuja.EMAIL.toString()),
                    rs.getDouble(ColumnsPuja.OFERTA.toString())
            );
        }
        
        rs.close();
        ps.close(); 
        pool.freeConnection(connection);
        return bid;    
    }
}
