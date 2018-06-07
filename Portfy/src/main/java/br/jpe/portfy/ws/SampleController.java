/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author joaovperin
 */
@Controller
public class SampleController {

    @GetMapping("test")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("I'm a bearpot.", HttpStatus.I_AM_A_TEAPOT);
    }

}
