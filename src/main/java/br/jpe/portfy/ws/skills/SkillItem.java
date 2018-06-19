/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.skills;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Skill Item table model
 *
 * @author joaovperin
 */
@Entity(name = "Skill_Item")
public class SkillItem implements Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Skill_Id")
    private int skillId;

    @Column(name = "Parent_Skill_Id")
    private int parentSkillId;

    /** User associated with the curriculum */
    @OneToOne
    @JoinColumn(name = "Parent_Skill_Id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private SkillItem parent;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description", nullable = true)
    private String description;

    protected SkillItem() {

    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getParentSkillId() {
        return parentSkillId;
    }

    public void setParentSkillId(int parentSkillId) {
        this.parentSkillId = parentSkillId;
    }

    public SkillItem getParent() {
        return parent;
    }

    public void setParent(SkillItem parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
