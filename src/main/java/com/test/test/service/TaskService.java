package com.test.test.service;

import java.util.List;

import com.test.test.bean.Tasks;

/**
 * @author Vignesh G
 */
public interface TaskService{
    /**
     * Save a CallLetter object.
     * @param tasks is the CallLetter object to be saved
     * @return id if the save operation is successful, false otherwise
     */
    public String save(Tasks task);

    /**
     * Retrieves all CallLetter objects.
     *
     * @return a list of CallLetter objects
     */
    public List<Tasks> getTasks();

    /**
     * Retrieves a Task object by its name.
     *
     * @param task the name of the task
     * @return the Task object associated with the given name
     */
    public Tasks getTask(String task);

    /**
     * Deletes a Task object by its name.
     *
     * @param task the name of the task to be deleted
     */
    public void deleteTask(String task);
}
