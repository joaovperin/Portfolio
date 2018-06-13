/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.contact;

import br.jpe.portfy.ws.user.User;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Contact table model
 *
 * @author joaovperin
 */
@Entity
public class Contact implements Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** Contact ID (will be the user ID) */
    @Id
    @Column(name = "User_Id", nullable = false)
    private Long id;

    /** User associated with the contact data */
    @OneToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private User user;

    @Column(name = "Cellphone")
    private String cellphone;
    @Column(name = "Country_Code")
    private String countryCode;
    @Column(name = "State_Code")
    private String stateCode;
    @Column(name = "State")
    private String state;
    @Column(name = "City")
    private String city;
    @Column(name = "Address")
    private String address;

    /**
     * Default constructor
     */
    protected Contact() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters
    public User getUser() {
        return user;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setUser(User user) {
        this.user = user;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
