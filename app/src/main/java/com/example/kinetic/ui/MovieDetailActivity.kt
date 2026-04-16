package com.example.kinetic.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kinetic.R

/**
 * Activity que muestra en detalle la movie seleccionada
 */
class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val imgMovie: ImageView = findViewById(R.id.imgMovie)
        val txtTitulo: TextView = findViewById(R.id.txtTitulo)
        val txtDescripcion: TextView = findViewById(R.id.txtDescripcion)
        val butonVerMovie: Button = findViewById(R.id.botonVerPelicula)

        val context: Context = this

        val titulo = intent.getStringExtra("titulo")
        val descripcion = intent.getStringExtra("descripcion")
        val pelicula = intent.getStringExtra("pelicula")
        val poster = intent.getStringExtra("imagen")

        // Convierte el String con el nombre del poster de la movie en un recurso Android
        val imageResId = context.resources.getIdentifier(
            poster,
            "drawable",
            context.packageName
        )

        imgMovie.setImageResource(imageResId)
        txtTitulo.text = titulo
        txtDescripcion.text = descripcion

        butonVerMovie.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            intent.putExtra("pelicula", pelicula)
            startActivity(intent)
        }

    }
}