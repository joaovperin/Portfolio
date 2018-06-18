/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.curriculum;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Experience table model
 *
 * @author joaovperin
 */
@Entity(name = "Experience")
public class Experience implements Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** Curriculum ID */
    @Id
    @Column(name = "Cv_Id")
    private Long id;

    /** Curriculum */
    @ManyToOne
    @JoinColumn(name = "Cv_Id", nullable = false)
    @JsonIgnore
    private Curriculum curriculum;

    @Id
    @Column(name = "Experience_Id")
    private int experienceId;

    @Column(name = "Job_Role")
    private String jobRole;

    @Column(name = "Company")
    private String company;

    @OneToMany(mappedBy = "experience")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ExperienceActivity> activities;

    @Column(name = "Initial_Date")
    @Temporal(TemporalType.DATE)
    private Date initialDate;

    @Column(name = "Final_Date")
    @Temporal(TemporalType.DATE)
    private Date finalDate;

    /**
     * Default constructor
     */
    protected Experience() {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(int experienceId) {
        this.experienceId = experienceId;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public List<ExperienceActivity> getActivities() {
        return activities;
    }

    public void setActivities(List<ExperienceActivity> activities) {
        this.activities = activities;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

}
