package com.example.kinetic.service

import android.content.Context
import com.example.kinetic.model.Movie
import org.json.JSONArray

/**
 * Clase encargada de obtener los datos del JSON
 */
class PersistenciaMovies(private val context: Context) {

    /**
     * Lee el contenido del archivo JSON y agrega cada una de las movies a la lista
     *
     * @return Lista de movies
     */
     fun readMovies(): List<Movie>{
        val jsonName = context.assets.open("movies.json")
        val jsonString = jsonName.bufferedReader().use { it.readText() }
        val jsonArray = JSONArray(jsonString)

        if (jsonArray.length() == 0) { return emptyList() }

        val movies = ArrayList<Movie>()

        for (i in 0 until jsonArray.length()){
            val jsonObj = jsonArray.getJSONObject(i)

            val titulo = jsonObj.getString("titulo")
            val descripcion = jsonObj.getString("descripcion")
            val movieVideo = jsonObj.getString("pelicula")
            val imagen = jsonObj.getString("imagen")

            movies.add( Movie(titulo, descripcion, movieVideo, imagen) )
        }

        return movies
    }
}