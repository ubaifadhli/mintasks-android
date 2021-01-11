package com.ubaifadhli.mintasks.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaskResponse {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("task")
    @Expose
    private Task task;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

}
