package com.junfan.moviemaster.ui.movie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.junfan.moviemaster.R
import com.junfan.moviemaster.data.model.PlayingMovieResponse
import com.junfan.moviemaster.data.model.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_adapter_movie.view.*

class MovieAdapter(var mContext: Context): RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    var mList: ArrayList<Result> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_adapter_movie, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var result = mList[position]
        holder.bind(result)
    }

    fun setData(list: ArrayList<Result>) {
        mList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(result: Result) {
            itemView.tv_movie_name.text = result.title
            var image_url = "https://image.tmdb.org/t/p/w500" + result.poster_path
            Picasso.get().load(image_url).into(itemView.row_adapter_image_view)
        }
    }
}