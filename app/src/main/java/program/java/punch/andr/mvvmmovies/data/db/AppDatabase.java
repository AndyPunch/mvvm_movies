package program.java.punch.andr.mvvmmovies.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import program.java.punch.andr.mvvmmovies.data.db.dao.FavouriteMovieDao;
import program.java.punch.andr.mvvmmovies.model.Movie;


@Database(entities = {Movie.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FavouriteMovieDao favouriteMovieDao();

}
