package com.junfan.moviemaster.ui.movie.trendingmovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.junfan.moviemaster.repository.MainRepository

class TrendingViewModelFactory(val mainRepository: MainRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TrendingViewModel(mainRepository) as T
    }
}