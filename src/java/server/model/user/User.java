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
    private Date birthday;
    private String address;
    private Dimens dimens;
    private Weight weight;
    private String licenseNo;
    private List<String> shipmentList;
    private Role role;
    
    //Constructor para el "Remitente" en el que no recibimos las medidas ni los pesos maximos
    public User(Credentials credentials,String name, String surname, Date bithday, String address, Role role){   
        this.credentials = credentials;
        this.name = name;
        this.surname = surname;
        this.birthday= birthday;
        this.address = address;
    }
    
    public User() {
        
    }
    public User(Credentials credentials) {
        this.credentials = credentials;
    }
    //Constructor para el transportista
   public User(Credentials credentials, String name, String surname,
           Date birthday, String address, Dimens dimens, 
           Weight weight, String licenseNo, Role role) {
        this.credentials = credentials;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.address = address;
        this.dimens = dimens;
        this.weight = weight;
        this.licenseNo = licenseNo;
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
    
    
    public void setUsername(String email){
        if (getCredentials() == null){
            this.credentials = new Credentials();
        }
        getCredentials().setEmail(email);
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
    
    public String getEmail(){
        return getCredentials().getEmail();
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

    public List<String> getShipmentList() {
        return shipmentList;
    }

    public void setShipmentList(List<String> shipmentList) {
        this.shipmentList = shipmentList;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }



}
