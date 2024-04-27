package com.physilink.security.form;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vignesh G
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);
        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if ("ADMIN".equals(auth.getAuthority())) {
                response.sendRedirect("/dashboard");
            }else if("AIDOS".equals(auth.getAuthority())){
                response.sendRedirect("/aidos/dashboard");
            }else if("CT".equals(auth.getAuthority())){
                response.sendRedirect("/ct/dashboard");
            }else if("MEDINS".equals(auth.getAuthority())){
                response.sendRedirect("/medins/dashboard");
            }
        }
    }
}
