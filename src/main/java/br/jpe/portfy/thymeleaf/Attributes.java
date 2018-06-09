/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.thymeleaf;

import br.jpe.portfy.exception.NotInstantiableException;

/**
 * HTML Attribute utilities
 *
 * @author joaovperin
 */
public final class Attributes {

    /** Class attribute */
    public static final String CLASS = "class";

    /**
     * Private constructor
     */
    private Attributes() {
        throw new NotInstantiableException();
    }

}
