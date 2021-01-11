package com.ubaifadhli.mintasks.data.network

import com.ubaifadhli.mintasks.data.model.*
import retrofit2.Call
import retrofit2.http.*

interface APIService {

    @POST("login")
    fun login(@Body user : User) : Call<LoginResponse>

    @POST("register")
    fun register(@Body user : User) : Call<RegisterResponse>

    @GET("profile")
    fun getProfile(@Header("Authorization") token : String) : Call<User>

    @GET("tasks")
    fun getTasks(@Header("Authorization") token : String) : Call<TasksResponse>

    @POST("task")
    fun createTask(@Header("Authorization") token : String, @Body task : Task) : Call<TaskResponse>

    @GET("task/{taskID}")
    fun getTask(@Path("taskID") taskID : String, @Header("Authorization") token : String) : Call<TaskResponse>

    @POST("task/{taskID}")
    fun updateTask(@Path("taskID", ) taskID : String, @Body task : Task, @Header("Authorization") token : String) : Call<TaskResponse>

    @PUT("task/checked/{taskID}")
    fun updateTaskChecked(@Path("taskID") taskID : String, @Header("Authorization") token : String) : Call<TaskResponse>

    @DELETE("task/{taskID}")
    fun deleteTask(@Path("taskID") taskID : String, @Header("Authorization") token : String) : Call<TaskResponse>
}