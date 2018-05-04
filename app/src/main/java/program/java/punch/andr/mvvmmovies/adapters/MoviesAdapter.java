package program.java.punch.andr.mvvmmovies.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import program.java.punch.andr.mvvmmovies.databinding.ItemMovieBinding;
import program.java.punch.andr.mvvmmovies.model.Movie;
import program.java.punch.andr.mvvmmovies.ui.main.viewModel.ItemMovieViewModel;
import program.java.punch.andr.mvvmmovies.ui.main.viewModel.MainViewModel;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesHolder> {

    private List<Movie> moviesList = new ArrayList<>();
    MainViewModel mMainViewModel;

    public MoviesAdapter(MainViewModel mMainViewModel) {
        this.mMainViewModel = mMainViewModel;
    }

    @NonNull
    @Override
    public MoviesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieBinding itemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent
                        .getContext()),
                parent, false);
        return new MoviesHolder(itemMovieBinding);
    }


    @Override
    public void onBindViewHolder(MoviesHolder holder, int position) {
        holder.bindMovie(moviesList.get(position));
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


    public class MoviesHolder extends RecyclerView.ViewHolder implements ItemMovieViewModel
            .ItemMovieViewModelListener {
        ItemMovieBinding mItemMovieBinding;

        public MoviesHolder(ItemMovieBinding itemMovieBinding) {
            super(itemMovieBinding.itemMovie);
            this.mItemMovieBinding = itemMovieBinding;
        }


        void bindMovie(Movie movie) {
            ItemMovieViewModel itemMovieViewModel = new ItemMovieViewModel(movie, this);
            mItemMovieBinding.setMovieItemViewModel(itemMovieViewModel);
            mItemMovieBinding.executePendingBindings();
        }

        @Override
        public void onAddFavouriteClick(Movie movie) {
            mMainViewModel.insertFavouriteMovie(movie);
        }
    }

    public void addMoviesToAdapter(List<Movie> l) {
        this.moviesList = l;
        notifyDataSetChanged();
    }

    public void clearMovies() {
        moviesList.clear();
        notifyDataSetChanged();
    }
}
