package com.junfan.moviemaster.repository

import com.junfan.moviemaster.repository.remote.ApiHelper

class MainRepository(val apiHelper: ApiHelper) {
    suspend fun getTrendingMovie() = apiHelper.getTrendingMovie()
    suspend fun getPlayingMovie() = apiHelper.getPlayingMovie()
}