/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws;

import br.jpe.portfy.exception.PortfyException;
import br.jpe.portfy.exception.UserNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * A class to handle errors
 *
 * @author joaovperin
 */
@RestControllerAdvice
public class ErrorHandler {

    /** Error */
    private static final String ERR = "error";
    /** Stack trace */
    private static final String STACK = "stack";

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

    /**
     * Handles User not found Exceptions
     *
     * @param e
     * @return String
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handleUserNotFound(UserNotFoundException e) {
        Map map = new HashMap<>();
        map.put("title", "Error Page :/");
        map.put(ERR, e.getMessage());
        map.put(STACK, null);
        return new ModelAndView("error/404.html", map);
    }

}
