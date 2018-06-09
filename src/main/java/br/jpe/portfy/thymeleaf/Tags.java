/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.thymeleaf;

import br.jpe.portfy.exception.NotInstantiableException;

/**
 * HTML Tag utilities
 *
 * @author joaovperin
 */
public final class Tags {

    /** Div tag */
    public static final String DIV = "div";

    /**
     * Private constructor
     */
    private Tags() {
        throw new NotInstantiableException();
    }

}
