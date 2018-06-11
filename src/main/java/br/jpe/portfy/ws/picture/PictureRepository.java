/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.picture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository of Pictures table
 *
 * @author joaovperin
 */
public interface PictureRepository extends JpaRepository<Picture, Long>, JpaSpecificationExecutor<Picture> {

    @Query(nativeQuery = true, value = "SELECT * FROM Picture WHERE User_Id = :userid LIMIT 1")
    public Picture findByUser(@Param("userid") Long userId);

}
