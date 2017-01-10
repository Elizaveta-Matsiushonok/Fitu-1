package com.linoge.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linoge.models.converters.UserConverter;
import com.linoge.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tim on 08.01.2017.
 */
@Service
public class SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String dataJson = new ObjectMapper().writeValueAsString(UserConverter.convertUserToDTO((User) userDetailsService
                .loadUserByUsername(authentication.getName())));
        response.getWriter().write(dataJson);
        System.out.println("AFTER Succces");
    }
}
