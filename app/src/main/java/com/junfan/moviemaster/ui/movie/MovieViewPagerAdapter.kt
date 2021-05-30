package com.junfan.moviemaster.ui.movie

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.junfan.moviemaster.ui.movie.playingmovie.PlayingMovieFragment
import com.junfan.moviemaster.ui.movie.trendingmovie.TrendingMovieFragment

class MovieViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    var favoriteMovieFragment: Fragment = TrendingMovieFragment()
    var playingMovieFragment: Fragment = PlayingMovieFragment()

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> favoriteMovieFragment
            else -> playingMovieFragment
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Trending Movies"
            else -> "Now Playing"
        }
    }
}