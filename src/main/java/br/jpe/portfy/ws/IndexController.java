/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws;

import br.jpe.portfy.exception.PortfyException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Index Page Controller
 *
 * @author joaovperin
 */
@Controller
@RequestMapping("/")
public class IndexController {

    /**
     * Mapping to the index URL
     *
     * @return ModelAndView
     */
    @GetMapping
    public ModelAndView index() {
        Map map = new HashMap<>();
        map.put("title", "Index");
        map.put("header", " - INDEX -");
        return new ModelAndView("index", map);
    }

    /**
     * Checks if an user exists on database
     *
     * @param user
     * @return ResponseEntity
     */
    @GetMapping("exists/{user}")
    public ResponseEntity<String> checkUserExists(@PathVariable String user) {
        // If user is not provided
        if (user == null || user.trim().isEmpty()) {
            return new ResponseEntity<>("User not provided.", HttpStatus.NOT_FOUND);
        }
        // User exists
        if (true) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        // User not found
        return new ResponseEntity<>(String.format("User '%s' doesn't exists.", user), HttpStatus.NOT_FOUND);
    }

    /**
     * Mapping to the index URL of an specific user
     *
     * @param user
     * @return ModelAndView
     * @throws br.jpe.portfy.exception.PortfyException
     */
    @GetMapping("{user}")
    public ModelAndView userIndex(@PathVariable String user) throws PortfyException {
        // TODO: Valid if the user exists and remove this .
        if (Arrays.asList("contact", "curriculum", "projects").contains(user)) {
            throw new PortfyException("Invalid URL!");
        }
        Map map = new HashMap<>();
        map.put("title", "Index - " + user);
        map.put("header", " - INDEX -");
        map.put("currentUser", user);
        return new ModelAndView("index", map);
    }

}
