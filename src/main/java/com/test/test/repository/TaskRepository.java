package com.test.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.test.test.bean.Tasks;

/**
 * @author Vignesh G
 */
@Repository
public interface TaskRepository extends MongoRepository<Tasks,String>{
    
    /**
    * Find a task by its name.
    *
    * @param taskName the name of the task
    * @return the task with the given name
    */
    Tasks findByTaskName(String taskName);

    /**
    * Delete a task by its name.
    *
    * @param task the name of the task to be deleted
    */
    void deleteByTaskName(String task);
}
