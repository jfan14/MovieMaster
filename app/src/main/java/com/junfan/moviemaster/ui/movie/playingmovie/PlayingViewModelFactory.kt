package com.junfan.moviemaster.ui.movie.playingmovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.junfan.moviemaster.repository.MainRepository

class PlayingViewModelFactory(val mainRepository: MainRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return PlayingViewModel(mainRepository) as T
    }
}