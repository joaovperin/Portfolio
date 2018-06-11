/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A Service to deal with User table things
 *
 * @author joaovperin
 */
@Service
public class UserService {

    @Autowired
    private UserRepository dao;

    /**
     * Checks if the username is valid
     *
     * @param user
     * @return boolean
     */
    public boolean isUsernameValid(String user) {
        return user == null || user.trim().isEmpty();
    }

    /**
     * Returns true if the users exists on the database
     *
     * @param user
     * @return boolean
     */
    public boolean exists(String user) {
        return dao.findByName(user) != null;
    }

    public User get(String user) {
        return dao.findByName(user);
    }

}
