/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.curriculum;

import br.jpe.portfy.ws.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Curriculum table model
 *
 * @author joaovperin
 */
@Entity(name = "Curriculum")
public class Curriculum implements Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** Curriculum ID */
    @Id
    @Column
    private Long id;

    /** User associated with the curriculum */
    @OneToOne
    @JoinColumn(name = "User_Id", nullable = false)
    @JsonIgnore  // TODO: Remove this line.
    private User user;

    @Column
    private String summary;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "curriculum")
    private PersonalData personalData;

    @OneToMany(mappedBy = "curriculum")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Objective> objectives;

    @OneToMany(mappedBy = "curriculum")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Formation> formations;

    @OneToMany(mappedBy = "curriculum")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Course> courses;

    @OneToMany(mappedBy = "curriculum")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Language> languages;

    @OneToMany(mappedBy = "curriculum")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Experience> experiences;

    @Column(name = "Last_Update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    /**
     * Default constructor
     */
    protected Curriculum() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

}
