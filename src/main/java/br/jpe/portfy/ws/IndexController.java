/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws;

import br.jpe.portfy.exception.UserNotFoundException;
import br.jpe.portfy.ws.user.UserService;
import br.jpe.portfy.ws.utils.ParamsService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService users;
    @Autowired
    private ParamsService params;

    /**
     * Mapping to the index URL
     *
     * @return ModelAndView
     */
    @GetMapping
    public ModelAndView index() {
        Map map = new HashMap<>();
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
        if (users.isUsernameValid(user)) {
            return new ResponseEntity<>("Username not provided.", HttpStatus.NOT_FOUND);
        }
        // User exists
        if (users.exists(user)) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        // User not found
        return new ResponseEntity<>(notFoundMsg(user), HttpStatus.NOT_FOUND);
    }

    /**
     * Mapping to the index URL of an specific user
     *
     * @param user
     * @return ModelAndView
     */
    @GetMapping("{user}")
    public Object userIndex(@PathVariable String user) {
        // If user doesn't exists
        if (!users.exists(user)) {
            throw new UserNotFoundException(notFoundMsg(user));
        }
        Map map = params.map(user);
        return new ModelAndView("index", map);
    }

    /**
     * "User not found" default return value
     *
     * @param user
     * @return ResponseEntity
     */
    private static String notFoundMsg(String user) {
        return String.format("The user '%s' doesn't exists.", user);
    }

}
