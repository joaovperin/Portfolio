/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.skills;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Skills Repository
 *
 * @author joaovperin
 */
public interface SkillRepository extends JpaRepository<Skill, SkillPk>, JpaSpecificationExecutor<Skill> {

    /**
     * Queries Skills from the user by the userId
     *
     * @param userId
     * @return List
     */
    @Query(nativeQuery = true, value = "SELECT * FROM Skill WHERE User_Id = :userid")
    public List<Skill> findByUser(@Param("userid") Long userId);

    /**
     * Queries Skills from the user by the username
     *
     * @param userName
     * @return List
     */
    @Query(nativeQuery = true, value = "SELECT S.* FROM Skill S INNER JOIN User U ON U.Id = S.User_Id WHERE U.Username = :userName")
    public List<Skill> findByUser(@Param("userName") String userName);

}
