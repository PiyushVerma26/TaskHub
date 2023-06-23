package com.example.task_manager

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(@PrimaryKey(autoGenerate = true) @ColumnInfo(name="Task_Id") val id :Int=0,
                @ColumnInfo(name = "Task_Title")val title:String,
                @ColumnInfo(name = "Task_Desc")val description: String)



