package com.test.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author Vignesh
 */
@Controller
public class HomeController {
	
    @RequestMapping("/login")
    public String login(@RequestParam("userId")String username,@RequestParam("pwd")String password) { 
        return "index";
    }

    @RequestMapping("/")
    public String home(){
        return "Home";
    }


  
}
