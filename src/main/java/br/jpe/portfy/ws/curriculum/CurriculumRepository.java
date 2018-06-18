/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.curriculum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository for the Curriculum entity
 *
 * @author joaovperin
 */
public interface CurriculumRepository extends JpaRepository<Curriculum, Long>, JpaSpecificationExecutor<Curriculum> {

    /**
     * Queries curriculum information by the userId
     *
     * @param userId
     * @return Curriculum
     */
    @Query(nativeQuery = true, value = "SELECT * FROM Curriculum WHERE User_Id = :userid LIMIT 1")
    public Curriculum findByUser(@Param("userid") Long userId);

    /**
     * Queries curriculum information by the userName
     *
     * @param userName
     * @return Curriculum
     */
    @Query(nativeQuery = true, value = "SELECT C.* FROM Curriculum C INNER JOIN User U ON U.Id = C.User_Id WHERE U.Username = :userName LIMIT 1")
    public Curriculum findByUser(@Param("userName") String userName);

}
