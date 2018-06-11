/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.exception;

/**
 * An exception to be thrown when the server doesn't finds a user
 *
 * @author joaovperin
 */
public class UserNotFoundException extends RuntimeException {

    /**
     * Default constructor
     *
     * @param message
     */
    public UserNotFoundException(String message) {
        super(message);
    }

}
