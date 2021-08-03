package com.serasa.manipulando_lista_interface.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.serasa.manipulando_lista_interface.R
import com.serasa.manipulando_lista_interface.adapter.AdapterListTodo
import com.serasa.manipulando_lista_interface.adapter.ClickableList
import com.serasa.manipulando_lista_interface.model.ListTodo
import com.serasa.manipulando_lista_interface.model.ListTodoLogoUrl

class MainActivity : AppCompatActivity(), ClickableList {

    private lateinit var todoRecyclerView: RecyclerView
    private lateinit var adapater: AdapterListTodo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfTodo()

    }

    fun listOfTodo() {
        val listOfTodoList = mutableListOf<ListTodo>(
            ListTodo("Teste1", "Teste1", ListTodoLogoUrl.LOGO),
            ListTodo("Teste2", "Teste2", ListTodoLogoUrl.LOGO),
            ListTodo("Teste3", "Teste3", ListTodoLogoUrl.LOGO),
            ListTodo("Teste4", "Teste4", ListTodoLogoUrl.LOGO),
        )

        // TODO: 03/08/21 Mostra na tela do RecyclerView
        adapater = AdapterListTodo(listOfTodoList, this)

        todoRecyclerView = findViewById(R.id.listOfTodoRecyclerView)
        todoRecyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
        todoRecyclerView.adapter = adapater

        // TODO: 03/08/21 Configurando buttons

    }

    override fun onEdit(todo: ListTodo) {
        TODO("Not yet implemented")
    }

    override fun onInfo(todo: ListTodo) {
        TODO("Not yet implemented")
    }

    override fun onDelete(todo: ListTodo) {

    }

}