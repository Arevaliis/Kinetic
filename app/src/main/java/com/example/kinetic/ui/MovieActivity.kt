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

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val pantalla = WindowInsetsControllerCompat(window, window.decorView)
        pantalla.hide(WindowInsetsCompat.Type.systemBars())
        pantalla.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        val videoView : VideoView = findViewById(R.id.videoView)
        val movie = intent.getStringExtra("pelicula")
        val context: Context = this

        val movieResId = context.resources.getIdentifier(
            movie,
            "raw",
            packageName
        )

        val controllers = MediaController(this)
        controllers.setAnchorView(videoView)
        videoView.setMediaController(controllers)

        val uri = "android.resource://${packageName}/$movieResId".toUri()
        videoView.setVideoURI(uri)
        videoView.start()
    }
}