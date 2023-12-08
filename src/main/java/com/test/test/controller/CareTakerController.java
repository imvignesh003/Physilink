package com.test.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.test.bean.Tasks;
import com.test.test.service.TaskService;

/**
 * @author Vignesh G
 */
@Controller
@RequestMapping("/caretaker")
public class CareTakerController {
    @Autowired
    TaskService taskService;
    
    @RequestMapping("/")
    public String home(Model model){
        List<Tasks> tasks = taskService.getTasks();
        model.addAttribute("tasks", tasks);
        return "Caretaker";
    }

    @RequestMapping("/add")
    public String add(@RequestParam("task") String task){
        Tasks t = new Tasks();
        t.setTaskName(task);
        t.setCompleted(false);
        taskService.save(t);
        return "Caretaker";
    }

    @RequestMapping("/tasks")
    public String show(Model model){
        List<Tasks> tasks = taskService.getTasks();
        model.addAttribute("tasks", tasks);
        return "aidos";
    }
}
