/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.test;

import br.jpe.portfy.ws.curriculum.Curriculum;
import br.jpe.portfy.ws.curriculum.CurriculumRepository;
import br.jpe.portfy.ws.picture.Picture;
import br.jpe.portfy.ws.picture.PictureService;
import br.jpe.portfy.ws.user.UserService;
import br.jpe.portfy.ws.utils.Jsons;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.ServletContextResource;
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

    //http://www.baeldung.com/spring-mvc-image-media-data
    //https://stackoverflow.com/questions/20673230/spring-boot-overriding-favicon
    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "/image-resource", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Resource> getImageAsResource() {
        HttpHeaders headers = new HttpHeaders();
        Resource resource = new ServletContextResource(servletContext, "/WEB-INF/images/image-example.jpg");
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    @Autowired
    private CurriculumRepository cvDao;
    @Autowired
    private UserService users;
    @Autowired
    private Jsons jsons;

    @GetMapping("two")
    public ResponseEntity two() {
        Long uId = users.get("joaovperin").getId();
        Curriculum one = cvDao.findByUser(uId);
        return new ResponseEntity(jsons.toFormattedJson(one), HttpStatus.OK);
    }

    @GetMapping("three")
    public ResponseEntity three() {
        Curriculum one = cvDao.findByUser("joaovperin");
        return new ResponseEntity(jsons.toFormattedJson(one), HttpStatus.OK);
    }

}
