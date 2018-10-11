package br.com.gwr.jetpackmovieproject.ui.adapter

import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import br.com.gwr.jetpackmovieproject.databinding.MovieItemBinding
import br.com.gwr.jetpackmovieproject.domain.model.Movie
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import br.com.gwr.jetpackmovieproject.R


/**
 * Created by WCisang on 21/06/2018.
 */
class MovieAdapter : ListAdapter<Movie, MovieAdapter.MovieViewHolder>(MOVIES_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<MovieItemBinding>(inflater, R.layout.movie_item, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MovieViewHolder(private var binding: MovieItemBinding?) : RecyclerView.ViewHolder(binding?.root) {

        fun bind(movie: Movie) {
            binding?.movie = movie
            binding?.executePendingBindings()
        }
    }

    companion object {
        private val MOVIES_COMPARATOR = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                    oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                    oldItem == newItem
        }

    }
}