/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.columns.ColumnsEnvio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import server.model.shipment.Shipment;
import server.model.shipment.ShipmentState;
import server.model.shipment.ShipmentType;
import server.model.user.Role;
import server.model.util.Dimens;
import server.model.util.DimensType;

/**
 *
 * @author garciparedes
 */
public class QueryShipment {
    private static final String QUERY_SHIPMENT_LIST_CARRIER = 
            "SELECT * FROM ENVIO , PUJA WHERE PUJA.EMAIL = ? AND ENVIO.NROENVIO = PUJA.NROENVIO";
    
    private static final String QUERY_SHIPMENT_LIST_CLIENT = "SELECT * FROM ENVIO WHERE EMAIL = ?";
    
    
    private static final String QUERY_SHIPMENT = 
            "SELECT * FROM ENVIO WHERE NROENVIO = ?";

    
    private static final String QUERY_SHIPMENT_TYPE = "SELECT VALOR FROM TIPOENVIO WHERE TIPO = ?";
    
    public static List<Shipment> getShipmentList(String email) throws SQLException{
        
        if (QueryUser.getRole(email) == Role.TRANSPORTISTA){
            return getShipmentList(email,QUERY_SHIPMENT_LIST_CARRIER);
        } else {
            return getShipmentList(email, QUERY_SHIPMENT_LIST_CLIENT);
        }
    }
    
    private static List<Shipment> getShipmentList(ResultSet rs) throws SQLException {
        List<Shipment> shipmentList = new ArrayList<>();
        Shipment shipment;
        while (rs.next()) {
            shipment = new Shipment(
                    rs.getInt(ColumnsEnvio.NROENVIO.toString()),
                    ShipmentType.valueOf(rs.getInt(ColumnsEnvio.TIPO.toString())),
                    "",
                    rs.getInt(ColumnsEnvio.PESO.toString()),
                    new Dimens(0,0,0,DimensType.METER),
                    rs.getString(ColumnsEnvio.ORIGEN.toString()),
                    rs.getString(ColumnsEnvio.DESTINO.toString()),
                    rs.getDate(ColumnsEnvio.FENVIO.toString()),
                    rs.getDate(ColumnsEnvio.FRECOGIDA.toString()),
                    QueryMilestone.getMilestoneList(
                            rs.getInt(ColumnsEnvio.NROENVIO.toString())),
                    QueryBid.getAssignedBid(
                            rs.getInt(ColumnsEnvio.NROENVIO.toString())),
                    QueryBid.getBidList(
                            rs.getInt(ColumnsEnvio.NROENVIO.toString())),
                    ShipmentState.valueOf(rs.getInt(ColumnsEnvio.ESTADO.toString()))      
            );
            shipmentList.add(shipment);
        }
        return shipmentList;
    }

    private static List<Shipment> getShipmentList(String email, String query) throws SQLException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, email);

        ResultSet rs = ps.executeQuery();

        List<Shipment> shipmentList = getShipmentList(rs);

        rs.close();
        ps.close(); 
        pool.freeConnection(connection);
        return shipmentList;
    }

    public static Shipment getShipment(int shipmentId) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        PreparedStatement ps = connection.prepareStatement(QUERY_SHIPMENT);

        ps.setInt(1, shipmentId);

        ResultSet rs = ps.executeQuery();

        Shipment shipment = null;
        if (rs.next()) {
            shipment = new Shipment(
                    rs.getInt(ColumnsEnvio.NROENVIO.toString()),
                    ShipmentType.valueOf(rs.getInt(ColumnsEnvio.TIPO.toString())),
                    "",
                    rs.getInt(ColumnsEnvio.PESO.toString()),
                    new Dimens(0,0,0,DimensType.METER),
                    rs.getString(ColumnsEnvio.ORIGEN.toString()),
                    rs.getString(ColumnsEnvio.DESTINO.toString()),
                    rs.getDate(ColumnsEnvio.FENVIO.toString()),
                    rs.getDate(ColumnsEnvio.FRECOGIDA.toString()),
                    QueryMilestone.getMilestoneList(
                            rs.getInt(ColumnsEnvio.NROENVIO.toString())),
                    QueryBid.getAssignedBid(
                            rs.getInt(ColumnsEnvio.NROENVIO.toString())),
                    QueryBid.getBidList(
                            rs.getInt(ColumnsEnvio.NROENVIO.toString())),
                    ShipmentState.valueOf(rs.getInt(ColumnsEnvio.ESTADO.toString()))      
            );
        }

        rs.close();
        ps.close(); 
        pool.freeConnection(connection);
        return shipment;          
    }
}
