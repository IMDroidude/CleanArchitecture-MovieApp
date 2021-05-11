package com.example.cleanarchitecture_movieapp.domain.datasource

import android.content.Context
import com.example.cleanarchitecture_movieapp.domain.models.MovieBO
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import org.json.JSONArray
import org.json.JSONObject
import xar.mvvm.xarlib.extensions.readFile
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDataSource @Inject constructor(
    @ApplicationContext val mContext: Context
) {

    fun getMoviesFromAsset(fileName:String):List<MovieBO>{
        val movies = arrayListOf<MovieBO>()
        val jsonString = mContext.assets.readFile(fileName)

        val movieArray = JSONObject(jsonString).getJSONArray("movies") as JSONArray
        for(i in 0 until movieArray.length()){
            val jsonMovieObject = movieArray.getJSONObject(i).toString()
            val movieItem = Gson().fromJson<MovieBO>(jsonMovieObject, MovieBO::class.java)
            movies.add(movieItem)
        }
        return movies
    }
}