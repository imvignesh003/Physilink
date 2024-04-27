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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/aidos")
@PreAuthorize("hasAuthority('AIDOS') or hasAuthority('ADMIN')")
public class AidosController {


    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;




    @GetMapping(value = "/dashboard")
    @PreAuthorize("hasAuthority('AIDOS') or hasAuthority('ADMIN')")
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView("aidos");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("currentUser", userDto);
        modelAndView.addObject("userName", userDto.getFullName());
        List<Task> tasks = taskService.getTasks();
        Collections.sort(tasks,new Comparator<Task>() {
            public int compare(Task t1, Task t2){
                return t1.isCompleted()?1:-1;
            }
        });
        modelAndView.addObject("tasks", tasks);
        return modelAndView;
    }

    @RequestMapping("/mark")
    @PreAuthorize("hasAuthority('AIDOS') or hasAuthority('ADMIN')")
    public String add(@RequestParam("taskName") String task) throws Exception{
        Task t = taskService.getTask(task);
        //taskService.deleteTask(task);
        t.setCompleted(!t.isCompleted());
        taskService.save(t);
        return "redirect:/aidos/dashboard";
    }

    @GetMapping(value = {"/logout"})
    @PreAuthorize("hasAuthority('AIDOS') or hasAuthority('ADMIN')")
    public String logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:login";
    }

}
