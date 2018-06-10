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

    @GetMapping
    public ModelAndView index() {
        Map map = new HashMap<>();
        map.put("title", "Index");
        map.put("header", " - INDEX -");
        return new ModelAndView("index", map);
    }

    @GetMapping("{user}")
    public ModelAndView userIndex(@PathVariable String user) throws Exception {
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

    @GetMapping("hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("I'm a bearpot.", HttpStatus.I_AM_A_TEAPOT);
    }

}
