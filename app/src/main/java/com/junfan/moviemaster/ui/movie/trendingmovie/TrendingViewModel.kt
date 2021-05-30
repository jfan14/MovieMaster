package com.junfan.moviemaster.ui.movie.trendingmovie

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junfan.moviemaster.data.model.TrendingResponse
import com.junfan.moviemaster.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TrendingViewModel(val mainRepository: MainRepository): ViewModel() {

    val trendingResponse = MutableLiveData<TrendingResponse>()
    val msg = MutableLiveData<String>()
    val process = MutableLiveData<Boolean>(true)

    fun getTrendingMovies() {

        viewModelScope.launch(Dispatchers.IO) {
            process.postValue(true)
            try {
                val response = mainRepository.getTrendingMovie()
                if(!response.isSuccessful) {
                    msg.postValue("Error occurs when get trending movies")
                }else{
                    trendingResponse.postValue(response.body())
                }
                process.postValue(false)
            }catch(e: Exception) {
                msg.postValue("Error occurs when get trending movies ${e.toString()}")
                process.postValue(false)
            }
        }
    }

}