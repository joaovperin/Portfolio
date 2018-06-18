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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Course table model
 *
 * @author joaovperin
 */
@Entity(name = "Course")
public class Course implements Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** Curriculum ID */
    @Id
    @Column(name = "Cv_Id")
    private Long id;

    /** Objective Sequence */
    @Id
    @Column
    private int sequence;

    /** Curriculum */
    @ManyToOne
    @JoinColumn(name = "Cv_Id", nullable = false)
    @JsonIgnore
    private Curriculum curriculum;

    @Column
    private String name;

    @Column
    private String school;

    @Column
    private int duration;

    @Temporal(TemporalType.DATE)
    @Column(name = "Expiration_Date")
    private Date expirationDate;

    /**
     * Default constructor
     */
    protected Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

}
