package com.linoge.config;

import org.springframework.security.core.Authentication;
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
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        System.out.println("AFTER Succces");
//        Cookie cookie = new Cookie("test", "testValue");
        //response.addCookie(cookie);
//        String dataJson = new ObjectMapper().writeValueAsString();
//        response.getWriter().append("").flush();
    }
}
