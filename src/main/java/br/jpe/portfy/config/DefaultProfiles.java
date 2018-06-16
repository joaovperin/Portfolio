/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.config;

import br.jpe.portfy.exception.NotInstantiableException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;

/**
 * Utility class to load a Spring profile to be used as default when there is no
 * <code>spring.profiles.active</code> set in the environment or as command line
 * argument. If the value is not available in <code>application.yml</code> then
 * <code>dev</code> profile will be used as default.
 */
public final class DefaultProfiles {

    /** Default profile property name */
    private static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";
    /** Developer profile name */
    private static final String DEV_PROFILE_NAME = "dev";

    /**
     * Private Constructor
     */
    private DefaultProfiles() {
        throw new NotInstantiableException();
    }

    /**
     * Set a default to use when no profile is configured.
     *
     * @param app the Spring application
     */
    public static void addDefaultProfile(SpringApplication app) {
        Map<String, Object> defProperties = new HashMap<>();
        /*
        * The default profile to use when no other profiles are defined
        * This cannot be set in the <code>application.yml</code> file.
        * See https://github.com/spring-projects/spring-boot/issues/1219
         */
        defProperties.put(SPRING_PROFILE_DEFAULT, DEV_PROFILE_NAME);
        app.setDefaultProperties(defProperties);
    }

}
