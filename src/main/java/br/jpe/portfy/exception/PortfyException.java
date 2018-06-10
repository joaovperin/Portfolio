/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.exception;

/**
 * A exception on the last layer
 *
 * @author joaovperin
 */
public class PortfyException extends Exception {

    /** Error Message */
    private final String errorMessage;

    /**
     * Default Constructor
     */
    public PortfyException() {
        this(null);
    }

    /**
     * Constructor
     *
     * @param errorMessage
     */
    public PortfyException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    /**
     * Error message
     *
     * @return String
     */
    public String getErrorMessage() {
        return errorMessage;
    }

}
