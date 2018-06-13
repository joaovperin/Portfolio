/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * A helper class to work with jsons
 *
 * @author joaovperin
 */
@Component
public class Jsons {

    @Autowired
    private Gson gson;

    public <B> B fromJson(String json, Class<B> clazz) {
        return gson.fromJson(json, clazz);
    }

    public String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public String formatJson(Object obj) {
        return gson.newBuilder().
                setPrettyPrinting().create().
                toJson(obj);
    }

    /**
     * Gson Factory
     */
    public static final class GsonFactory {

        @Bean
        public static Gson gson() {
            return new GsonBuilder().create();
        }

    }

}
