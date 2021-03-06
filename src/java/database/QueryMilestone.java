/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.columns.ColumnsHito;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import server.model.shipment.milestone.Milestone;
import server.model.shipment.milestone.MilestoneType;

/**
 *
 * @author garciparedes
 */
public class QueryMilestone {
    
    private static final String QUERY_MILESTONELIST = 
            "SELECT * FROM HITO WHERE HITO.NROENVIO = ? ORDER BY NROHITO";
    private static final String QUERY_ADD_MILESTONE = 
            "INSERT INTO HITO VALUES(?,?,?,?,?,?)";

    
    public static void addMilestone(String email, int shipmentId, Milestone milestone) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = connection.prepareStatement(QUERY_ADD_MILESTONE);
        ps.setInt(1, shipmentId);
        ps.setInt(2, QueryShipment.getShipment(shipmentId).getMilestoneList().size());
        ps.setString(3, milestone.getBody());
        ps.setInt(4, 0);
        ps.setString(5, email);
        ps.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));

        ps.executeUpdate();
        ps.close(); 
        pool.freeConnection(connection);
        
    }
    protected static List<Milestone> getMilestoneList(int shipmentId) throws SQLException{
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        PreparedStatement ps = connection.prepareStatement(QUERY_MILESTONELIST);
        
        ps.setInt(1, shipmentId);
        
        ResultSet rs = ps.executeQuery();
        
        List<Milestone> milestoneList = new ArrayList();
        Milestone milestone;
        while (rs.next()) {
            milestone = new Milestone(
                rs.getDate(ColumnsHito.FCREACION.toString()),
                MilestoneType.COMMENT,
                rs.getString(ColumnsHito.MENSAJE.toString()),
                rs.getString(ColumnsHito.AUTOR.toString())
            );   
            milestoneList.add(milestone);
        }
        
        rs.close();
        ps.close(); 
        pool.freeConnection(connection);
        return milestoneList; 
    }
}
