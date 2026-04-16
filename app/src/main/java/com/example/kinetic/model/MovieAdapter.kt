package com.example.kinetic.model

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.kinetic.R
import androidx.recyclerview.widget.RecyclerView

/**
 * Clase encargada de la configuración del Adapter para mostrar las movies dentro de un RecyclerView
 */
class MovieAdapter (
    private val lista:List<Movie>,
    private val context: Context,
    private val onClick: (Movie) -> Unit

): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    /**
     * Clase que contiene las referencias de cada elemento dentro del layout
     */
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val titulo: TextView = view.findViewById(R.id.txtTitulo)
        val descripcion: TextView = view.findViewById(R.id.txtDescripcion)
        val imagen: ImageView = view.findViewById(R.id.imgMovie)
    }

    // Crea la vista del layout
    override fun onCreateViewHolder( parent: ViewGroup,  viewType: Int ): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(vista)
    }

    // Vincula la información de la movie a cada elemento creado en la class ViewHolder
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = lista[position]

        holder.titulo.text = pelicula.titulo
        holder.descripcion.text = pelicula.descripcion

        val imageResId = context.resources.getIdentifier(
            pelicula.imagen,
            "drawable",
            context.packageName
        )

        holder.imagen.setImageResource(imageResId)

        holder.itemView.setOnClickListener { onClick(pelicula) }
    }

    // Devuelve el tamaño de la lista de movies
    override fun getItemCount(): Int {  return lista.size }
}