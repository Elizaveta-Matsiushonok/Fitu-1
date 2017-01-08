package com.linoge.controllers;

import com.linoge.models.converters.UserConverter;
import com.linoge.models.dto.UserDTO;
import com.linoge.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tim on 08.01.2017.
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping(path = "/getcurrentuser", method = RequestMethod.GET)
    public UserDTO getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return UserConverter.convertUserToDTO((User) userDetailsService
                .loadUserByUsername(auth.getName())); //get logged in username
    }
}
