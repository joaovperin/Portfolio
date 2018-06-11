/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    /**
     * Default constructor
     */
    protected User() {
    }

    // Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
