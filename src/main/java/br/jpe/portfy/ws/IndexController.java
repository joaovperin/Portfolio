/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for the Index page
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
        Map model = new HashMap<>();
        return new ModelAndView("index", model);
    }

}
