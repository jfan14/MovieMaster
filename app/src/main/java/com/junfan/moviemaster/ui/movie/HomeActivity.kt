package com.junfan.moviemaster.ui.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.junfan.moviemaster.R
import com.junfan.moviemaster.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var movieViewPagerAdapter: MovieViewPagerAdapter
    lateinit var vBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(vBinding.root)

        init()
    }

    private fun init() {
        movieViewPagerAdapter = MovieViewPagerAdapter(supportFragmentManager)
        vBinding.viewPager.adapter = movieViewPagerAdapter
        vBinding.tabLayout.setupWithViewPager(vBinding.viewPager)
    }


}