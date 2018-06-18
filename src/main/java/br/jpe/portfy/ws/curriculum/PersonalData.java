/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.curriculum;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Personal Data table model
 *
 * @author joaovperin
 */
@Entity(name = "Personal_Data")
public class PersonalData implements Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** Curriculum ID */
    @Id
    @Column(name = "Cv_Id")
    private Long id;

    /** User associated with the curriculum */
    @OneToOne
    @JoinColumn(name = "Cv_Id", nullable = false)
    @JsonIgnore
    private Curriculum curriculum;

    @Column
    private String nacionality;

    @Column
    private String relationship;

    @Column
    private String address;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    /**
     * Default constructor
     */
    protected PersonalData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
