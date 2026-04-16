package com.example.kinetic.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kinetic.R
import com.example.kinetic.model.MovieAdapter
import com.example.kinetic.service.PersistenciaMovies

/**
 * Activity encargada de mostrar el catalogo de películas
 */
class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        // Contexto actual de la Activity
        val context: Context = this

        val recycleMovies: RecyclerView = findViewById(R.id.recyclerMovies)
        recycleMovies.layoutManager = LinearLayoutManager(this)

        // Leemos los datos del JSON
        val listaMovies = PersistenciaMovies(context).readMovies()

        val adapter = MovieAdapter(listaMovies, context) { pelicula ->
            val intent = Intent(this, MovieDetailActivity::class.java)

            intent.putExtra("titulo", pelicula.titulo)
            intent.putExtra("descripcion", pelicula.descripcion)
            intent.putExtra("pelicula", pelicula.pelicula)
            intent.putExtra("imagen", pelicula.imagen)

            startActivity(intent)
        }

        recycleMovies.adapter = adapter
    }
}