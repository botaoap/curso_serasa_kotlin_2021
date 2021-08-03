package com.serasa.manipulando_lista_interface.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.serasa.manipulando_lista_interface.R
import com.serasa.manipulando_lista_interface.model.ListTodo

class EditTodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_todo)
        
        val todo = intent.getSerializableExtra("parametro-todo") as? ListTodo

        // TODO: 03/08/21 Faz um button de voltar no canto superior direito 
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        
        // TODO: busca as informacoes necessarias da lista e mostra em outra tela em detalhe
        todo?.let { 
            findViewById<ImageView>(R.id.logoDetailImageView).apply {
                Glide.with(context)
                    .load(todo.logo.url)
                    .placeholder(R.drawable.ic_baseline_error_24)
                    .into(this)
            }
            findViewById<TextView>(R.id.titleDetailTextView).apply {
                text = todo.title
            }
            findViewById<TextView>(R.id.descriptiomDetailTextView).apply {
                text = todo.description
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}