package com.example.contatosrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContatosAdapter : RecyclerView.Adapter<ContatosAdapter.viewHolder>() {
    var listContatos : MutableList<Contato> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contato_item,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return listContatos.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(listContatos[position])
    }
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val imageView : ImageView = itemView.findViewById(R.id.imageView_photo)
        private val textViewName : TextView = itemView.findViewById(R.id.textView_nome)
        private val textViewTelefone : TextView = itemView.findViewById(R.id.textView_telefone)
        fun bind(contact : Contato){
            textViewName.text = contact.nome
            textViewTelefone.text = contact.telefone

        }
    }
    fun updateListContatos(lista : List<Contato>){
        this.listContatos.clear()
        listContatos.addAll(lista)
        notifyDataSetChanged()
    }
}