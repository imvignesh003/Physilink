package com.physilink.dto.mapper;

import com.physilink.model.task.Task;
import com.physilink.dto.model.task.TaskDto;

public class TaskMapper {
    public static TaskDto toTaskDto(Task task){
        return new TaskDto()
                .setCompleted(task.isCompleted())
                .setTaskName(task.getTaskName());
    }
}
