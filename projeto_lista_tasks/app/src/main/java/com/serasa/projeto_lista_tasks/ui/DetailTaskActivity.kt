package com.serasa.projeto_lista_tasks.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.serasa.projeto_lista_tasks.R
import com.serasa.projeto_lista_tasks.model.Task

class DetailTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_task)

        val task = intent.getSerializableExtra("parametro-task") as? Task

        // TODO: Adicionar uma flecha de voltar para a tela onde estava
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        task?.let {
            findViewById<ImageView>(R.id.logoImageView).apply {
                Glide.with(context)
                    .load(task.logo.url)
                    .placeholder(R.drawable.ic_baseline_error_24)
                    .into(this)
            }
            findViewById<TextView>(R.id.nameTextView).apply {
                text = task.nomeTask
            }
            findViewById<TextView>(R.id.descritionTextView).apply {
                text = task.descritionTask
            }

        }
    }

    // TODO: faz com que a flecha de voltar funcione
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}