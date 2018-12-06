package program.java.punch.andr.mvvmmovies.data;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import program.java.punch.andr.mvvmmovies.data.db.dbHelper.interfaces.DbHelper;
import program.java.punch.andr.mvvmmovies.data.remote.ApiHelper;
import program.java.punch.andr.mvvmmovies.model.Movie;
import program.java.punch.andr.mvvmmovies.model.Movies;

public class AppDataController implements DataController {

    private final DbHelper mDbHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataController(Context context, DbHelper dbHelper, ApiHelper apiHelper) {
        mDbHelper = dbHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public Single<Boolean> insertFavouriteMovie(Movie movie) {
        return mDbHelper.insertFavouriteMovie(movie);
    }

    @Override
    public Observable<List<Movie>> getFavouriteMovies() {
        return mDbHelper.getFavouriteMovies();
    }

    @Override
    public Completable deleteFavourite(Movie movie) {
        return mDbHelper.deleteFavourite(movie);
    }


    @Override
    public Observable<Movies> getMovies(String apikey, String type, String title) {

        return mApiHelper.getMovies(apikey, type, title);
    }
}
