/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.picture;

import br.jpe.portfy.ws.user.User;
import br.jpe.portfy.ws.user.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A Service to deal with User table things
 *
 * @author joaovperin
 */
@Service
public class PictureService {

    @Autowired
    private PictureRepository dao;
    @Autowired
    private UserRepository userDao;

    public List<Picture> list() {
        return dao.findAll();
    }

    public Picture getPicture(User usr) {
        return dao.findByUser(usr.getId());
    }

    public Picture getPictureFrom(String usr) {
        User user = userDao.findByName(usr);
        return user != null ? getPicture(user) : null;
    }

}
