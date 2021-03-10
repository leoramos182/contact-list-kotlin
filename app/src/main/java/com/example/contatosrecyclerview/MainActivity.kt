package com.example.contatosrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
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
                 "Carlos Silva",
                 "(21) 96724-8664",
                 "img.jpg"
                )
            ))
    }
    private fun toastMessage(message : String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
    override fun onCreateOptionsMenu(menu : Menu?) : Boolean{
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item_menu_um -> {
                toastMessage("Menu um tocado!")
                true
            }
            R.id.menu_dois -> {
                toastMessage("Menu dois tocado!")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}