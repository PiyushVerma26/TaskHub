package com.example.task_manager

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {
@Query("SELECT * FROM tasks")
fun getAllTasks():LiveData<List<Task>>

@Insert
suspend fun insertTask(task:Task)

@Update
suspend fun updateTask(task:Task)

@Delete
suspend fun deleteTask(task:Task)
}