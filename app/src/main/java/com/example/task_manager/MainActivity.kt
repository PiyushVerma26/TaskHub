package com.example.task_manager

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task_manager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TaskDeleteInterface, TaskClickInterface {
    private lateinit var binding: ActivityMainBinding
    private lateinit var taskViewModel: TaskViewModel
    private lateinit var adapter: TaskAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Recycle.setHasFixedSize(true)
        binding.Recycle.layoutManager=LinearLayoutManager(this)
        adapter=TaskAdapter(this, this)
        binding.Recycle.adapter=adapter

        taskViewModel= ViewModelProvider(this)[TaskViewModel::class.java]
        taskViewModel.allTasks.observe(this) { task ->
            run {
                task?.let {
                    adapter.setTasks(it)
                    adapter.notifyDataSetChanged()

                }
            }
        }

        binding.floating.setOnClickListener{
    startActivity(Intent(this@MainActivity, AddActivity::class.java))

}


    }

//    override fun onDeleteIconClick(task: Task) {
//taskViewModel.deleteTask(task)
//        Toast.makeText(this,"${task.title} Successfully Deleted",Toast.LENGTH_SHORT).show()
//    }
@SuppressLint("NotifyDataSetChanged")
override fun onDeleteIconClick(task: Task) {
    taskViewModel.deleteTask(task)
    Toast.makeText(this, "${task.title} Successfully Deleted", Toast.LENGTH_SHORT).show()
}


    override fun onTaskIconClick(task: Task) {
val intent=Intent(this@MainActivity,AddActivity::class.java)
        intent.putExtra("taskType","Edit")
        intent.putExtra("taskTitle",task.title)
        intent.putExtra("taskDesc",task.description)
        intent.putExtra("taskId",task.id)
        startActivity(intent)
    }
}
