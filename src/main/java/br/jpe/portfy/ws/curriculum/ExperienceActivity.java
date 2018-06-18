/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.curriculum;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 * Experience Activity table model
 *
 * @author joaovperin
 */
@Entity(name = "Experience_Activity")
public class ExperienceActivity implements Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** Curriculum ID */
    @Id
    @Column(name = "Cv_Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Cv_Id", nullable = false)
    @JsonIgnore
    private Curriculum curriculum;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "Cv_Id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "Experience_Id", nullable = false, insertable = false, updatable = false)
    })
    @JsonIgnore
    private Experience experience;

    @Id
    @Column(name = "Experience_Id")
    private int experienceId;

    @Id
    @Column(name = "Sequence")
    private int sequence;

    @Column(name = "Activity")
    private String activity;

    /**
     * Default constructor
     */
    protected ExperienceActivity() {
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

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public int getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(int experienceId) {
        this.experienceId = experienceId;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

}
