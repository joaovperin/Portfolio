/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.curriculum;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author joaovperin
 */
@RestController
@RequestMapping("curriculum")
public class CurriculumController {

    @GetMapping
    public ModelAndView index() {
        Map map = new HashMap<>();
        map.put("title", "Curriculum");
        map.put("header", " - Curriculum -");
        return new ModelAndView("curriculum/index.html", map);
    }
}
