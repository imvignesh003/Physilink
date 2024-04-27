package com.physilink.repository.task;

import com.physilink.model.task.Task;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TaskRepository extends MongoRepository<Task,String> {

    /**
     * Find a task by its name.
     *
     * @param taskName the name of the task
     * @return the task with the given name
     */
    Task findByTaskName(String taskName);

    /**
     * Delete a task by its name.
     *
     * @param taskName the name of the task to be deleted
     */
    void deleteByTaskName(String taskName);
}
