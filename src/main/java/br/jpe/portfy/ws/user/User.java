/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.user;

import br.jpe.portfy.ws.picture.Picture;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.NaturalId;

/**
 * User table model
 *
 * @author joaovperin
 */
@Entity
public class User implements Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** Auto generated ID */
    @Id
    @Column
    private Long id;

    /** Username */
    @NaturalId
    @NotEmpty
    @Column(unique = true, nullable = false, length = 5)
    private String username;

    /** Password */
    @Column(nullable = false, length = 8)
    private String password;

    /** E-mail */
    @Column(nullable = false, length = 8)
    private String email;

    /** First name */
    @Column(nullable = false, length = 2)
    private String firstname;

    /** Last name */
    @Column(nullable = false, length = 2)
    private String lastname;

    /** Description */
    @Column(nullable = false, length = 30)
    private String description;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private Picture picture;

    /**
     * Default constructor
     */
    protected User() {
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDescription() {
        return description;
    }

    public Picture getPicture() {
        return picture;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

}
