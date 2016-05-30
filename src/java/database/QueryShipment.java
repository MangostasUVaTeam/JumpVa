/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.columns.ColumnsEnvio;
import java.sql.Connection;
import java.sql.Date;
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
import server.model.util.Weight;
import server.model.util.WeightType;

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

    private static final String QUERY_SHIPMENT_COUNT = 
            "SELECT COUNT(*) FROM ENVIO";
    
    private static final String QUERY_ADD_SHIPMENT = 
            "INSERT INTO ENVIO VALUES(?,?,?,?,?,?,?,?,?,NULL,?)";
    
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
                    new Weight(rs.getInt(ColumnsEnvio.PESO.toString()), WeightType.KILOGRAM),
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
                    new Weight(rs.getInt(ColumnsEnvio.PESO.toString()), WeightType.KILOGRAM),
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
    
    public static void insertShipment(String email, Shipment shipment) throws SQLException{
        /*
        shipment.setId(getShipmentCount());
            
        System.out.println(shipment.getId());
        email;
        System.out.println(shipment.getWeight());
        System.out.println(shipment.getType());
        System.out.println(shipment.getDimens());
        System.out.println(shipment.getPickUpDate());
        System.out.println(shipment.getArrivalDate());
        System.out.println(shipment.getOrigin());
        System.out.println(shipment.getDestination());

        shipment.setState(ShipmentState.UNASSIGNED);
        */
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = connection.prepareStatement(QUERY_ADD_SHIPMENT);
        
        ps.setInt(1, getShipmentCount());
        ps.setString(2, email);
        ps.setInt(3, (int) shipment.getWeight().getValue());
        ps.setInt(4, shipment.getType().ordinal());
        ps.setString(5, "");
        ps.setDate(6, new Date(shipment.getPickUpDate().getTime()));
        ps.setDate(7, new Date(shipment.getArrivalDate().getTime()));
        ps.setString(8, shipment.getDestination());
        ps.setString(9, shipment.getOrigin());
        ps.setInt(10, ShipmentState.UNASSIGNED.ordinal());

        ps.executeUpdate();
        ps.close(); 
        pool.freeConnection(connection);
        
    }
    
    public static int getShipmentCount() throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        PreparedStatement ps = connection.prepareStatement(QUERY_SHIPMENT_COUNT);

        ResultSet rs = ps.executeQuery();
        
        int count = 0;
        if (rs.next()) {
            count = rs.getInt(1);
        }

        rs.close();
        ps.close(); 
        pool.freeConnection(connection);
        return count;
    }
}
