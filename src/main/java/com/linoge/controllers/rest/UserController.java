package com.linoge.controllers.rest;

import com.linoge.models.converters.UserConverter;
import com.linoge.models.dto.UserDTO;
import com.linoge.models.entities.User;
import com.linoge.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tim on 08.01.2017.
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    UserService userService;

    @RequestMapping(path = "/getcurrentuser", method = RequestMethod.GET)
    public UserDTO getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return UserConverter.convertUserToDTO((User) userDetailsService
                .loadUserByUsername(auth.getName())); //get logged in username
    }

    @RequestMapping(path = "/createuser", method = RequestMethod.POST)
    public void createUser(@RequestParam("username") String username,
                           @RequestParam("password") String password){
        userService.createUser(username, password);
    }
}
