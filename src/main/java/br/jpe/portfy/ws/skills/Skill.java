/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.skills;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Skill table model
 *
 * @author joaovperin
 */
@Entity(name = "Skill")
public class Skill implements Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "User_Id")
    private int userId;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "")
    private SkillItem head;

    @Column(name = "Head_Skill_Id", insertable = false, updatable = false)
    private int headSkillId;

    protected Skill() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public SkillItem getHead() {
        return head;
    }

    public void setHead(SkillItem head) {
        this.head = head;
    }

    public int getHeadSkillId() {
        return headSkillId;
    }

    public void setHeadSkillId(int headSkillId) {
        this.headSkillId = headSkillId;
    }

}
