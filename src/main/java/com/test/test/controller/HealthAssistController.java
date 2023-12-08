package com.test.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Vignesh G
 */
@Controller
@RequestMapping("/healthassist")
public class HealthAssistController {
    
    @RequestMapping("/")
    public String home(Model model){
        return "healthassist";
    }
}
