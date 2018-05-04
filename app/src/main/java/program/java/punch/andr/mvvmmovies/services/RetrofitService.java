package program.java.punch.andr.mvvmmovies.services;

import io.reactivex.Observable;
import program.java.punch.andr.mvvmmovies.model.Movies;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RetrofitService {

    @GET("/?apikey=8d82b59e&?type=movie")
    Observable<Movies> getMovies(@Query("s") String Title);

}
