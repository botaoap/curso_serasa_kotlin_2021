package com.serasa.manipulando_lista_interface.ui

import android.content.Intent
import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.core.graphics.Insets.add
import androidx.core.view.OneShotPreDrawListener.add
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

    override fun onAdd(todo: ListTodo) {
        adapater.add(ListTodo("AddTest","AddDescription",ListTodoLogoUrl.LOGO))
    }

    override fun onEdit(todo: ListTodo) {
        // TODO: 03/08/21 Navegar para a tela de Detail
        val intentToDetailTodoActivity = Intent(this, EditTodoActivity::class.java)
        intentToDetailTodoActivity.putExtra("parametro-todo", todo)
        startActivity(intentToDetailTodoActivity)
    }

    override fun onDelete(todo: ListTodo) {
        if (todoRecyclerView.adapter is AdapterListTodo) {
            (todoRecyclerView.adapter as AdapterListTodo).removeTodo(todo)
        }
    }


    // TODO: 03/08/21 Tentativa de fazer um alerta para delete
//    fun basicAlert(view: View){
//        val builder = AlertDialog.Builder(this)
//        with(builder)
//        {
//            setTitle("Androidly Alert")
//            setMessage("We have a message")
//            setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
//            setNegativeButton("No", negativeButtonClick)
//            show()
//        }
//
//    }


}