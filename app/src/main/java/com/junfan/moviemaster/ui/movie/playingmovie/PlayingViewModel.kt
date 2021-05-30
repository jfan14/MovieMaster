package com.junfan.moviemaster.ui.movie.playingmovie

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junfan.moviemaster.data.model.PlayingMovieResponse
import com.junfan.moviemaster.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class PlayingViewModel(val mainRepository: MainRepository): ViewModel() {

    val playingMovieResponse = MutableLiveData<PlayingMovieResponse>()
    val processing = MutableLiveData<Boolean>(true)
    val msg = MutableLiveData<String>()

    fun getPlayingMovie(){

        viewModelScope.launch(Dispatchers.IO) {
            processing.postValue(true)
            try{
                val response = mainRepository.getPlayingMovie()
                if(!response.isSuccessful) {
                    msg.postValue("Error occurred when get Playing movies")
                }else{
                    playingMovieResponse.postValue(response.body())
                }
                processing.postValue(false)
            }catch (e: Exception) {
                e.printStackTrace()
                processing.postValue(false)
                Log.d("abcde", "Error occured. Error is : ${e.toString()}")
                msg.postValue("Error occured. Error is : ${e.toString()}")
            }
        }
    }
}