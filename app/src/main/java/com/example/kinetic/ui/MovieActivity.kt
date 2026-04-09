package com.example.kinetic.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.kinetic.R

// TODO Agregar videos, mejorar UI y conseguir pantalla completa.

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        supportActionBar?.hide()

        setContentView(R.layout.activity_movie)

        window.decorView.setOnApplyWindowInsetsListener { v, insets ->
            insets.consumeSystemWindowInsets()
        }

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