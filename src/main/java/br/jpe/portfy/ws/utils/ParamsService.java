/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.ws.utils;

import br.jpe.portfy.ws.user.UserService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Params utilities
 *
 * @author joaovperin
 */
@Service
public class ParamsService {

    /** User parameter name */
    private static final String USER_PARAM = "usr";
    /** Current User parameter name */
    private static final String CURRENT_USER_PARAM = "currentUser";

    @Autowired
    private UserService users;

    /**
     * Creates and return a Map with default attributes for the user
     *
     * @param user
     * @return Map
     */
    public final Map<String, Object> map(String user) {
        Map map = new HashMap<>();
        map.put(CURRENT_USER_PARAM, user);
        map.put(USER_PARAM, users.get(user));
        return map;
    }

}
