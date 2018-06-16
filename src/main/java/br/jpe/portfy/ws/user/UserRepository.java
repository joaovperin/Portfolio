/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository of Users table
 *
 * @author joaovperin
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    /**
     * Finds a User by it's name
     *
     * @param name
     * @return User
     */
    @Query(nativeQuery = true, value = "SELECT * FROM User WHERE Username = :name LIMIT 1")
    public User findByName(@Param("name") String name);

}
