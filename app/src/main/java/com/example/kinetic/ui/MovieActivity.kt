package com.example.kinetic.ui

import android.content.Context
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.kinetic.R

/**
 * Activity encargada de reproducir la movie
 */
class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        // Permite ocultar las barras del sistema para visualizar la movie en Full screen
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val pantalla = WindowInsetsControllerCompat(window, window.decorView)
        pantalla.hide(WindowInsetsCompat.Type.systemBars())
        pantalla.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        val videoView : VideoView = findViewById(R.id.videoView)
        val movie = intent.getStringExtra("pelicula")
        val context: Context = this

        // Convierte el String con el nombre de la película en un recurso Android
        val movieResId = context.resources.getIdentifier(
            movie,
            "raw",
            packageName
        )

        // Controles de reproducción
        val controllers = MediaController(this)
        controllers.setAnchorView(videoView)
        videoView.setMediaController(controllers)

        // Construye la URI para obtener la movie
        val uri = "android.resource://${packageName}/$movieResId".toUri()
        videoView.setVideoURI(uri)
        videoView.start()
    }
}