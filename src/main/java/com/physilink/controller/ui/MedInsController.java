package com.physilink.controller.ui;

import com.physilink.dto.model.user.UserDto;
import com.physilink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/medins")
@PreAuthorize("hasAuthority('MEDINS') or hasAuthority('ADMIN')")
public class MedInsController {

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    @PreAuthorize("hasAuthority('MEDINS') or hasAuthority('ADMIN')")
    public ModelAndView dashboard() {

        ModelAndView modelAndView = new ModelAndView("medins");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("currentUser", userDto);
        modelAndView.addObject("userName", userDto.getFullName());
        return modelAndView;
    }

    @GetMapping(value = {"/logout"})
    @PreAuthorize("hasAuthority('MEDINS') or hasAuthority('ADMIN')")
    public String logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:login";
    }
}
