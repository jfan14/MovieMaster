package com.junfan.moviemaster.ui.movie.playingmovie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.junfan.moviemaster.R
import com.junfan.moviemaster.repository.MainRepository
import com.junfan.moviemaster.repository.remote.ApiClient
import com.junfan.moviemaster.repository.remote.ApiHelper
import com.junfan.moviemaster.repository.remote.ApiService
import com.junfan.moviemaster.ui.movie.MovieAdapter
import kotlinx.android.synthetic.main.fragment_playing_movie.view.*

class PlayingMovieFragment : Fragment() {

    lateinit var movieAdapter: MovieAdapter
    lateinit var viewModel: PlayingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_playing_movie, container, false)
        init(view)
        return view
    }

    fun init(view: View) {
        movieAdapter = MovieAdapter(requireContext())
        view.playing_movie_recycler_view.adapter = movieAdapter
        view.playing_movie_recycler_view.layoutManager = GridLayoutManager(activity, 2)

        val mainRepository = MainRepository(ApiHelper(ApiClient.getApiClient().create(ApiService::class.java)))
        val factory = PlayingViewModelFactory(mainRepository)
        viewModel = ViewModelProvider(this, factory).get(PlayingViewModel::class.java)

        setUpObserver()
        viewModel.getPlayingMovie()
    }

    private fun setUpObserver() {
        viewModel.msg.observe(viewLifecycleOwner) {
            Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
        }

        viewModel.playingMovieResponse.observe(viewLifecycleOwner) { playingMovieResponse ->
            if(playingMovieResponse.total_results > 0) {
                Toast.makeText(activity, "Request successful", Toast.LENGTH_LONG).show()
                Log.d("abcde", "${playingMovieResponse.results}")
                movieAdapter.setData(playingMovieResponse.results)
            }else{
                Toast.makeText(activity, "Request Failed", Toast.LENGTH_LONG).show()
            }
        }
    }
}