package com.test.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.test.bean.Tasks;
import com.test.test.repository.TaskRepository;

/**
 * @author Vignesh G
 */
@Service
public class TaskServiceImpl implements TaskService{
    
    @Autowired
    private TaskRepository repository;

    @Override
    public String save(Tasks task){
        return repository.save(task).getId();

    }

    @Override
    public List<Tasks> getTasks(){
        return repository.findAll();
    }

    @Override
    public Tasks getTask(String task){
        return repository.findByTaskName(task);
    }

    @Override
    public void deleteTask(String task){
        repository.deleteByTaskName(task);
    }
}
