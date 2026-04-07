package com.example.kinetic.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.kinetic.R
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter (
    private val lista:List<Movie>,
    private val onClick: (Movie) -> Unit

): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        // val titulo: TextView = view.findViewById()
        // val imagen: ImageView = view.findViewById()
    }

    override fun onCreateViewHolder( parent: ViewGroup,  viewType: Int ): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
       /* val pelicula = lista[position]

        holder.titulo.text = pelicula.titulo
        holder.imagen.setImageResource(pelicula.image)

        holder.itemView.setOnClickListener {
            onClick(pelicula)
        }*/
    }

    override fun getItemCount(): Int {  return lista.size }
}