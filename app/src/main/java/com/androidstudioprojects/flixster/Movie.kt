package com.androidstudioprojects.flixster

import org.json.JSONArray

data class Movie (
    val movieID: Int,
    val title: String,
    val overview: String,
    private val posterPath: String,
    private val thumbPath: String
){
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    val thumbnailUrl = "https://image.tmdb.org/t/p/w342/$thumbPath"
    companion object{
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()){
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("title"),
                        movieJson.getString("overview"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("backdrop_path")
                    )
                )
            }
            return movies
        }
    }
}