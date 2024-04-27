package com.physilink.service;

import com.physilink.repository.task.TaskRepository;
import com.physilink.model.task.Task;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public String save(Task task){
        return taskRepository.save(task).getId();
    }

    @Override
    public List<Task> getTasks(){


        return taskRepository.findAll();
    }

    @Override
    public Task getTask(String taskName) throws Exception {
        return taskRepository.findByTaskName(taskName);
    }

    @Override
    public void deleteTask(String taskName){
        taskRepository.deleteByTaskName(taskName);
    }


}
