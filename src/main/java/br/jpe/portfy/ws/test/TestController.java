/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.test;

import br.jpe.portfy.ws.picture.Picture;
import br.jpe.portfy.ws.picture.PictureService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * A controller for a /test page. It's used only for DEVELOPMENT TESTS. ...to be
 * removed before oficial release.
 *
 * @author joaovperin
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public ModelAndView index() {
        Map map = new HashMap<>();
        map.put("title", "TESTE");
        map.put("header", " - TESTEEE -");
        return new ModelAndView("test/index.html", map);
    }

    @Autowired
    private PictureService pic;

    @GetMapping("list")
    public ResponseEntity list() {
        List<Picture> list = pic.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("one")
    public ResponseEntity one() {
        Picture one = pic.getPictureFrom("joaovperin");
        return new ResponseEntity(one, HttpStatus.OK);
    }

}
