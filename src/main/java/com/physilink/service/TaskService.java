package com.physilink.service;

import com.physilink.model.task.Task;

import java.util.List;


public interface TaskService {
    /**
     * Save a CallLetter object.
     * @param task is the CallLetter object to be saved
     * @return id if the save operation is successful, false otherwise
     */
    public String save(Task task);

    /**
     * Retrieves all CallLetter objects.
     *
     * @return a list of CallLetter objects
     */
    public List<Task> getTasks();

    /**
     * Retrieves a Task object by its name.
     *
     * @param taskName the name of the task
     * @return the Task object associated with the given name
     */
    public Task getTask(String taskName) throws Exception;

    /**
     * Deletes a Task object by its name.
     *
     * @param taskName the name of the task to be deleted
     */
    public void deleteTask(String taskName);
}
