package br.com.gwr.jetpackmovieproject.ui.adapter

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import br.com.gwr.jetpackmovieproject.databinding.MovieItemBinding
import br.com.gwr.jetpackmovieproject.domain.model.Movie

/**
 * Created by WCisang on 21/06/2018.
 */
class MovieAdapter : PagedListAdapter<Movie, MovieAdapter.MovieViewHolder>(REPO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

    }

    class MovieViewHolder(private var binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                    oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                    oldItem == newItem
        }

    }
}