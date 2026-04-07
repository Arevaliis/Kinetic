package com.example.kinetic.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kinetic.R
import com.example.kinetic.model.Movie
import com.example.kinetic.model.MovieAdapter

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val recyclePeliculas: RecyclerView = findViewById(R.id.recyclerPeliculas)
        recyclePeliculas.layoutManager = LinearLayoutManager(this)

        val peliculas = listOf(
            Movie("Video 1", R.drawable.ic_launcher_background, "Descripcion",
                R.raw.video1 )
        )

        val adapter = MovieAdapter(peliculas) { pelicula ->
            val intent = Intent(this, VideoActivity::class.java)
            intent.putExtra("pelicula", pelicula.pelicula)
            startActivity(intent)
        }

        recyclePeliculas.adapter = adapter
    }
}