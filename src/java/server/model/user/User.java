/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ws.rs.QueryParam;
import server.model.shipment.ShipmentType;
import server.model.util.Dimens;
import server.model.util.Weight;

/**
 *
 * @author garciparedes
 */
public class User implements Serializable {
    
    private Credentials credentials;
    private String name;
    private String surname;
    private String email;
    private Date birthday;
    private String address;
    private Dimens dimens;
    private Weight weight;
    private List<ShipmentType> shipmentTypeList;
    private Role role;
    
    public User(){   
    }
   public User(Credentials credentials, String name, String surname, 
           String email, Date birthday, String address, Dimens dimens, 
           Weight weight, List<ShipmentType> shipmentTypeList, Role role) {
        this.credentials = credentials;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
        this.dimens = dimens;
        this.weight = weight;
        this.shipmentTypeList = shipmentTypeList;
        this.role = role;
    }

    public User(Credentials credentials, Role role) {
        this.credentials = credentials;
        this.role = role;
    }
    
    public void setPassword(String password){
        if (getCredentials() == null){
            this.credentials = new Credentials();
        }
        getCredentials().setPassword(password);
    }
    
    
    public void setUsername(String username){
        if (getCredentials() == null){
            this.credentials = new Credentials();
        }
        getCredentials().setUsername(username);
    }
    
    public void setRole(Role role){
        this.role = role;
    }
    
    private Credentials getCredentials() {
        return credentials;
    }
    
    public String getPassword(){
        return getCredentials().getPassword();
    }
    
    public String getUsername(){
        return getCredentials().getUsername();
    }
    
    
    public Role getRole(){
        return role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Dimens getDimens() {
        return dimens;
    }

    public void setDimens(Dimens dimens) {
        this.dimens = dimens;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public List<ShipmentType> getShipmentTypeList() {
        return shipmentTypeList;
    }

    public void setShipmentTypeList(List<ShipmentType> shipmentTypeList) {
        this.shipmentTypeList = shipmentTypeList;
    }



}
