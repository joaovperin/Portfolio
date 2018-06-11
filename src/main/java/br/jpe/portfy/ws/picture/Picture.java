/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.picture;

import br.jpe.portfy.ws.user.User;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.NaturalId;

/**
 * A Model for the Picture entity
 *
 * @author joaovperin
 */
@Entity
public class Picture implements Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** Auto generated ID */
    @Id
    @Column
    private Long id;

    /** User associated with the image */
    @NaturalId
    @NotEmpty
    @OneToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private User user;

    /** Image filename */
    @Column(nullable = false, length = 8)
    private String filename;

    /** Title */
    @Column(nullable = true)
    private String title;

    /** Alternative text */
    @Column(nullable = true)
    private String alt;

    /**
     * Default constructor
     */
    protected Picture() {
    }

    // Getters
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getFilename() {
        return filename;
    }

    public String getTitle() {
        return title;
    }

    public String getAlt() {
        return alt;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

}
