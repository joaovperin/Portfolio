/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.curriculum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Curriculum Service
 *
 * @author joaovperin
 */
@Service
public class CurriculumService {

    @Autowired
    private CurriculumRepository dao;

    /**
     * Finds the user curriculum
     *
     * @param user
     * @return Curriculum
     */
    public Curriculum get(String user) {
        return dao.findByUser(user);
    }

}
