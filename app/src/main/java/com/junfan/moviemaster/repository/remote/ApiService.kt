package com.junfan.moviemaster.repository.remote

import com.junfan.moviemaster.app.Config
import com.junfan.moviemaster.data.model.PlayingMovieResponse
import com.junfan.moviemaster.data.model.TrendingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("trending/movie/week")
    suspend fun getTrendingMovie(
        @Query("api_key") apiKey:String = Config.API_KEY
    ): Response<TrendingResponse>

    @GET("movie/now_playing")
    suspend fun getPlayingMovie(
        @Query("api_key") apiKey:String = Config.API_KEY
    ): Response<PlayingMovieResponse>

}