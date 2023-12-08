package com.test.test.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * @author Vignesh G
 */
@Document(collection = "Tasks")
@Data
public class Tasks {
    @Id
    private String id;
    private String taskName;
    private boolean completed;
}
