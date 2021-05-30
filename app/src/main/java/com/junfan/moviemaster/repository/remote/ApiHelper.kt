package com.junfan.moviemaster.repository.remote

class ApiHelper(val apiService: ApiService) {
    suspend fun getTrendingMovie() = apiService.getTrendingMovie()
    suspend fun getPlayingMovie() = apiService.getPlayingMovie()
}