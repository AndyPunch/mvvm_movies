package program.java.punch.andr.mvvmmovies.data.db.dbHelper.interfaces;

import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import program.java.punch.andr.mvvmmovies.model.Movie;


@Singleton
public interface DbHelper {
    Single<Boolean> insertFavouriteMovie(Movie movie);

    Observable<List<Movie>> getFavouriteMovies();

    Completable deleteFavourite(Movie movie);
}
