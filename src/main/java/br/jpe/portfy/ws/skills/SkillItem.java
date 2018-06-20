/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.skills;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Skill Item table model
 *
 * @author joaovperin
 */
@Entity(name = "Skill_Item")
public class SkillItem implements Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    @Column(name = "User_Id")
    private Long userId;

    @Id
    @Column(name = "Skill_Id")
    private Long skillId;

    @ManyToOne
    @JsonIgnore
    private SkillItem parent;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description", nullable = true)
    private String description;

    @OneToMany(mappedBy = "parent")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<SkillItem> children;

    protected SkillItem() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
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

    public List<SkillItem> getChildren() {
        return children;
    }

    public void setChildren(List<SkillItem> children) {
        this.children = children;
    }

}
