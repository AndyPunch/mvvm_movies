package program.java.punch.andr.mvvmmovies.ui.main.interfaces;

import java.util.List;

import program.java.punch.andr.mvvmmovies.model.Movie;

public interface MainMvvmView {

    void startSearch();

    void updateAdapter(List<Movie> moviesList);

    void onMovieInserted(Boolean aBoolean);
}
