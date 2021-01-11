package com.ubaifadhli.mintasks.data.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TasksResponse {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("task")
    @Expose
    private ArrayList<Task> tasks = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

}
