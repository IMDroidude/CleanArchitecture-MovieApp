package com.example.cleanarchitecture_movieapp.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture_movieapp.databinding.ItemMovieListBinding
import com.example.cleanarchitecture_movieapp.domain.models.MovieBO

class MoviesAdapter(var movies:MutableList<MovieBO>,val click:(position:Int,movieBO:MovieBO)->Unit) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemMovieListBinding = ItemMovieListBinding.inflate(inflater,parent,false)
        return MovieViewHolder(itemMovieListBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies.get(position))
    }
    override fun getItemCount(): Int  = movies.size

    fun setItems(itemList:MutableList<MovieBO>){
        movies = itemList
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemMovieListBinding: ItemMovieListBinding) : RecyclerView.ViewHolder(itemMovieListBinding.root){
        init {
            itemView.setOnClickListener { click.invoke(adapterPosition,movies.get(adapterPosition)) }
        }
        fun bind(movie:MovieBO){

        }
    }
}


val movieDiff = object : DiffUtil.ItemCallback<MovieBO>() {
    override fun areItemsTheSame(oldItem: MovieBO, newItem: MovieBO): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: MovieBO, newItem: MovieBO): Boolean {
        return oldItem == newItem
    }
}