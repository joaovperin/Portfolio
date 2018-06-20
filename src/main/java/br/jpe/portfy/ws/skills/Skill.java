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
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Skill table model
 *
 * @author joaovperin
 */
@Entity(name = "Skill")
@IdClass(SkillPk.class)
public class Skill implements Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "User_Id")
    @JsonIgnore
    private Long userId;

    @Id
    @Column(name = "Head_Skill_Id", insertable = false, updatable = false)
    @JsonIgnore
    private Long headSkillId;

    @OneToMany
    @JoinColumns({
        @JoinColumn(name = "User_Id", referencedColumnName = "User_Id"),
        @JoinColumn(name = "Skill_Id", referencedColumnName = "Head_Skill_Id")
    })
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<SkillItem> items;

    protected Skill() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHeadSkillId() {
        return headSkillId;
    }

    public void setHeadSkillId(Long headSkillId) {
        this.headSkillId = headSkillId;
    }

    public List<SkillItem> getItems() {
        return items;
    }

    public void setItems(List<SkillItem> items) {
        this.items = items;
    }

}
