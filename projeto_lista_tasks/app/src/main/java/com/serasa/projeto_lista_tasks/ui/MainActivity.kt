package com.serasa.projeto_lista_tasks.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.serasa.projeto_lista_tasks.R
import com.serasa.projeto_lista_tasks.adapter.AdapterTaskRecycleView
import com.serasa.projeto_lista_tasks.model.Task
import com.serasa.projeto_lista_tasks.model.TaskLogoUrl

class MainActivity : AppCompatActivity() {

    private lateinit var tasksRecycleView: RecyclerView
    private lateinit var adapter: AdapterTaskRecycleView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaDeTasks()
    }

    fun listaDeTasks() {

        val listOfTask = mutableListOf<Task>(
            Task("Academia", "Segunda a sexta as 19h", TaskLogoUrl.ACADEMIA),
            Task("Mercado", "Comprar: pao, leite, carne", TaskLogoUrl.MERCADO),
            Task("Lazer", "Sabado viajar", TaskLogoUrl.LAZER),
            Task("Trabalho", "Segunda a sexta das 9h as 18h", TaskLogoUrl.TRABALHO),
        )

        adapter = AdapterTaskRecycleView(listOfTask) {
            onClickItemTask(it)
        }

        findViewById<Button>(R.id.buttonAddNewTask).setOnClickListener {
            onClickAddNewTask()
        }

        tasksRecycleView = findViewById(R.id.tasksRecycleView)
        tasksRecycleView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL,
            false
        )
        tasksRecycleView.adapter = adapter



    }

    fun onClickItemTask(task: Task){
//        Snackbar.make(tasksRecycleView, task.nomeTask, Snackbar.LENGTH_LONG).show()
        // TODO: navegar para outra tela
        val intentParaDeatilTaskDoTask = Intent(this, DetailTaskActivity::class.java)
        intentParaDeatilTaskDoTask.putExtra("parametro-task", task)
        startActivity(intentParaDeatilTaskDoTask)

    }

    fun onClickAddNewTask() {
        adapter.add(Task("Lazer","Lazer todos finais de semana",TaskLogoUrl.LAZER))
    }
}