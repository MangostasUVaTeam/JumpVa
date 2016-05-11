/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.columns.ColumnsHito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    
    protected static List<Milestone> getMilestoneList(int shipmentId) throws SQLException{
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        PreparedStatement ps = connection.prepareStatement(QUERY_MILESTONELIST);
        
        ps.setInt(1, shipmentId);
        
        ResultSet rs = ps.executeQuery();
        
        List<Milestone> milestoneList = new ArrayList();
        Milestone bid;
        while (rs.next()) {
            bid = new Milestone(
                    rs.getDate(ColumnsHito.FCREACION.toString()),
                    MilestoneType.COMMENT,
                    rs.getString(ColumnsHito.MENSAJE.toString())
            );
            milestoneList.add(bid);
        }
        
        rs.close();
        ps.close(); 
        pool.freeConnection(connection);
        return milestoneList; 
    }
}
