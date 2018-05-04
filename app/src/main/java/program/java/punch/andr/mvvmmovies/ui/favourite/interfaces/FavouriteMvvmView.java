package program.java.punch.andr.mvvmmovies.ui.favourite.interfaces;

import java.util.List;

import program.java.punch.andr.mvvmmovies.model.Movie;

public interface FavouriteMvvmView {

    void onMoviesLoaded(List<Movie> moviesList);

    void OnFavouriteDeleted(List<Movie> moviesList);
}
