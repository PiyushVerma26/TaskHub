package com.example.task_manager

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(
    private val taskClickInterface: TaskClickInterface,
    private val taskDeleteInterface: TaskDeleteInterface
)
    : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {


//    private val allTask=ArrayList<Task>()
    private var allTask: List<Task> = emptyList()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  =LayoutInflater.from(parent.context).inflate(R.layout.task_rv_item,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return allTask.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val count = position + 1
        holder.taskTitle.text = allTask[position].title
        holder.desc.text=allTask[position].description
        holder.textId.text= count.toString()


        holder.deleteIm.setOnClickListener{
            taskDeleteInterface.onDeleteIconClick(allTask[position])
        }
        holder.itemView.setOnClickListener{
            taskClickInterface.onTaskIconClick(allTask[position])
        }
    }


//ViewHolder Class

    inner class ViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView)
    {
        val taskTitle: TextView= itemView.findViewById(R.id.title)
        val desc: TextView =itemView.findViewById(R.id.desc)
        val textId : TextView=itemView.findViewById(R.id.idNO)
        val deleteIm : ImageButton=itemView.findViewById(R.id.delete)
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setTasks(tasks: List<Task>) {
        allTask = tasks
        notifyDataSetChanged()
    }

}

interface TaskDeleteInterface{
    fun onDeleteIconClick(task:Task)
}
interface TaskClickInterface{
    fun onTaskIconClick(task:Task)
}