/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.skills;

import java.io.Serializable;
import java.util.Objects;

/**
 * Primary Key for Skill entity
 *
 * @author joaovperin
 */
public class SkillPk implements Serializable {

    private Long userId;
    private Long headSkillId;

    public SkillPk() {
    }

    public SkillPk(Long userId, Long headSkillId) {
        this.userId = userId;
        this.headSkillId = headSkillId;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.userId);
        hash = 83 * hash + Objects.hashCode(this.headSkillId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SkillPk other = (SkillPk) obj;
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return Objects.equals(this.headSkillId, other.headSkillId);
    }

}
