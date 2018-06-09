/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.exception;

/**
 * An exception to be thrown by objects that cannot be instantiated (if they
 * are)
 *
 * @author joaovperin
 */
public class NotInstantiableException extends IllegalStateException {

    /** Message */
    private static final String MESSAGE = "You can't instantiate that!";

    /**
     * Default constructor
     */
    public NotInstantiableException() {
        super(MESSAGE);
    }

}
