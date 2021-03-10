package com.example.contatosrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contato_item.*

class MainActivity : AppCompatActivity() {
    private val rvList : RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }
    private val adapter = ContatosAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        updateContactList()
    }
    fun bindViews(){
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)

    }
    private fun updateContactList(){
        adapter.updateListContatos(
            listOf(Contato(
            "Joao Silva",
            "(21) 96724-8664",
            "img.jpg"
        ),
             Contato(
                 "Joao Silva",
                 "(21) 96724-8664",
                 "img.jpg"
                )
            ))
    }
}