/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository of Contact table
 *
 * @author joaovperin
 */
public interface ContactRepository extends JpaRepository<Contact, Long>, JpaSpecificationExecutor<Contact> {

    @Query(nativeQuery = true, value = "SELECT * FROM Contact WHERE User_Id = :userid LIMIT 1")
    public Contact findByUser(@Param("userid") Long userId);

}
