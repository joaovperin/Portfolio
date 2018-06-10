/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws;

import br.jpe.portfy.exception.PortfyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * A class to handle errors
 *
 * @author joaovperin
 */
@RestControllerAdvice
public class ErrorHandler {

    /**
     * Handles PortfyExceptions
     *
     * @param e
     * @return String
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PortfyException.class)
    public String handleNoHandlerFoundException(PortfyException e) {
        if (e.getErrorMessage() != null) {
            return e.getErrorMessage();
        }
        return "Specified path not found on this server";
    }

}
