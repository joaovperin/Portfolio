/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.curriculum;

import java.security.InvalidParameterException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 *
 * @author joaovperin
 */
@Service
public class LanguageFormatter {

    private static final int LEVEL_NATIVE = 1;
    private static final int LEVEL_FLUENT = 2;
    private static final int LEVEL_HIGH = 3;
    private static final int LEVEL_MEDIUM = 4;
    private static final int LEVEL_LOW = 5;

    public static String fmtLanguageLevel(int level) {
        if(level==LEVEL_NATIVE) return "Native";
        if(level==LEVEL_FLUENT) return "Fluent";
        if(level==LEVEL_HIGH) return "Advanced";
        if(level==LEVEL_MEDIUM) return "Intermediate";
        if(level==LEVEL_LOW) return "Basic";
        throw new InvalidParameterException("Cannot format language level '" + level + "'.");
    }
   
}
