/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.test;

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
@RequestMapping("test")
public class TestController {

    @GetMapping
    public ModelAndView index() {
        Map map = new HashMap<>();
        map.put("title", "TESTE");
        map.put("header", " - TESTEEE -");
        return new ModelAndView("test/index.html", map);
    }
}
