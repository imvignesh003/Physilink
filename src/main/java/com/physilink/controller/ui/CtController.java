package com.physilink.controller.ui;

import com.physilink.dto.model.user.UserDto;
import com.physilink.model.task.Task;
import com.physilink.service.TaskService;
import com.physilink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/ct")
@PreAuthorize("hasRole('CT') or hasRole('ADMIN')")
public class CtController {

    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;

    @GetMapping("/dashboard")
    @PreAuthorize("hasAuthority('CT') or hasAuthority('ADMIN')")
    public ModelAndView home() throws Exception {
        ModelAndView modelAndView = new ModelAndView("ct");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        System.out.println(auth.getCredentials());
        System.out.println(auth.getPrincipal());
        System.out.println(auth.getClass());
//        if(auth.getAuthorities().contains(UserRoles.CT) || auth.getAuthorities().contains(UserRoles.ADMIN)){
            UserDto userDto = userService.findUserByEmail(auth.getName());
            List<Task> tasks = taskService.getTasks();
            modelAndView.addObject("currentUser", userDto);
            modelAndView.addObject("userName", userDto.getFullName());
            modelAndView.addObject("tasks", tasks);
            return modelAndView;
//        }
//        throw new Exception("Authorization Required");
    }

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('CT') or hasAuthority('ADMIN')")
    public String add(@RequestParam("task") String task){
        ModelAndView modelAndView = new ModelAndView("ct");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        Task t = new Task();
        t.setTaskName(task);
        t.setCompleted(false);
        taskService.save(t);
        modelAndView.addObject("currentUser", userDto);
        modelAndView.addObject("userName", userDto.getFullName());
        return "redirect:/ct/dashboard";
    }

    /*@RequestMapping("/tasks")
    public String show(Model model){
        List<Tasks> tasks = taskService.getTasks();
        model.addAttribute("tasks", tasks);
        return "aidos";
    }*/
    @GetMapping(value = {"/logout"})
    @PreAuthorize("hasAuthority('CT') or hasAuthority('ADMIN')")
    public String logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:login";
    }
}
