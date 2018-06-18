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
import javax.persistence.ManyToOne;

/**
 * Objective table model
 *
 * @author joaovperin
 */
@Entity(name = "Objective")
public class Objective implements Serializable {

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

    /** Objective */
    @Column
    private String objective;

    /**
     * Default constructor
     */
    protected Objective() {
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

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

}
