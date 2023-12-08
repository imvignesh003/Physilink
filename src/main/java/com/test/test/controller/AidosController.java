package com.test.test.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.test.bean.Tasks;
import com.test.test.service.TaskService;

/**
 * @author Vigensh G
 */
@Controller
@RequestMapping("/aidos")
public class AidosController {
    
    @Autowired
    TaskService taskService;
    
    @RequestMapping("/")
    public String home(Model model){
        List<Tasks> tasks = taskService.getTasks();
        Collections.sort(tasks,new Comparator<Tasks>() {
            public int compare(Tasks t1, Tasks t2){
                return t1.isCompleted()?1:-1;
            }
        });
        model.addAttribute("tasks", tasks);
        return "Aidos";
    }

    @RequestMapping("/mark")
    public String add(@RequestParam("taskName") String task){
        Tasks t = taskService.getTask(task);
        //taskService.deleteTask(task);
        t.setCompleted(!t.isCompleted());
        taskService.save(t);
        return "redirect:/aidos/";
    }

    // @RequestMapping("/tasks")
    // public List<Tasks> show(Model model){
    //     List<Tasks> tasks = taskService.getTasks();
    //     model.addAttribute("tasks", tasks);
    //     return tasks;
    // }
}
