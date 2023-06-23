package com.example.task_manager

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.task_manager.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private lateinit var taskViewModel: TaskViewModel
    private var taskId = -1

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        taskViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[TaskViewModel::class.java]

        val taskType = intent.getStringExtra("taskType")
        if (taskType == "Edit") {
            val taskTitle = intent.getStringExtra("taskTitle")
            val taskDesc = intent.getStringExtra("taskDesc")
            taskId = intent.getIntExtra("taskId", -1)
            binding.btn.text = "Confirm and Update"
            binding.editTitle.setText(taskTitle)
            binding.editDesc.setText(taskDesc)
        } else {
            binding.btn.text = "Confirm and Save"
        }

        binding.btn.setOnClickListener {
            val title = binding.editTitle.text.toString()
            val desc = binding.editDesc.text.toString()

            if (taskType == "Edit") {
                if (title.isNotEmpty() && desc.isNotEmpty()) {
                    val update = Task(taskId, title, desc)
                    taskViewModel.updateTask(update)
                    Toast.makeText(this, "Successfully task is Updated", Toast.LENGTH_SHORT).show()
                }
            } else {
                if (title.isNotEmpty() && desc.isNotEmpty()) {
                    taskViewModel.insertTask(Task(title = title, description = desc))
                    Toast.makeText(this, "Task Added Successfully", Toast.LENGTH_SHORT).show()
                }
            }

            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }
}
