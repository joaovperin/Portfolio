/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.curriculum;

import br.jpe.portfy.ws.utils.ParamsService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for the curriculum page
 *
 * @author joaovperin
 */
@RestController
@RequestMapping("/user/{user}/curriculum")
public class CurriculumController {

    @Autowired
    private ParamsService params;

    /**
     * URL Mapping for the view page
     *
     * @param user
     * @return ModelAndView
     */
    @GetMapping
    public ModelAndView index(@PathVariable String user) {
        Map map = params.map(user);
        return new ModelAndView("curriculum/index.html", map);
    }
}
